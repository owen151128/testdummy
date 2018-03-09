package com.q.testdummy;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.q.testdummy.databinding.ActivityMainBinding;
import com.q.testdummy.imageview.TestImageViewFragment;
import com.q.testdummy.vo.TestImageViewVo;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends RxAppCompatActivity implements MainContract.View {
    private ActivityMainBinding binding;
    private MainContract.Presenter presenter;
    private ArrayList<TestImageViewVo> itemList;
    private long timer;
    private TestImageViewFragment testImageViewFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMain(this);
        presenter = new MainPresenter(this);
        itemList = new ArrayList<>();
        initTestImageViewFragment();
        binding.saveButton.setOnLongClickListener(v -> {
            onButtonLongClick(v);
            return true;
        });
    }

    @Override
    public void onBackPressed() {
        long now = SystemClock.uptimeMillis();
        if (now - timer < 2000)
            finish();
        else {
            showToast(R.string.back_button_toast);
            timer = now;
        }
    }

    @Override
    public void showToast(String text) {
        Toast toast = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#ffffff'>" + text + "</font>"), Toast.LENGTH_SHORT);
        ViewGroup group = (ViewGroup) toast.getView();
        TextView textView = (TextView) group.getChildAt(0);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        toast.getView().setBackgroundResource(R.drawable.custom_toast);
        toast.show();
    }

    @Override
    public void showToast(int resourceId) {
        Toast toast = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#ffffff'>" + getString(resourceId) + "</font>"), Toast.LENGTH_SHORT);
        ViewGroup group = (ViewGroup) toast.getView();
        TextView textView = (TextView) group.getChildAt(0);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        toast.getView().setBackgroundResource(R.drawable.custom_toast);
        toast.show();
    }

    @Override
    public void addItem(TestImageViewVo vo) {
        itemList.add(vo);
        testImageViewFragment.add(vo);
    }

    public void initTestImageViewFragment() {
        if (getSupportFragmentManager().findFragmentById(R.id.content) == null) {
            testImageViewFragment = TestImageViewFragment.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.add(R.id.content, testImageViewFragment);
            fragmentTransaction.commit();
        }
    }

    public void onButtonClick(View view) {
        String text = binding.editText.getText().toString();
        if (text.equals("")) {
            showToast(R.string.edit_text_null_toast);
        } else {
            if (itemList.isEmpty()) {
                presenter.onClickButton(R.drawable.image, text, getApplicationContext());
            } else {
                if (getSupportFragmentManager().findFragmentById(R.id.content) == null) {
                    for (TestImageViewVo vo : itemList) {
                        addItem(vo);
                    }
                } else {
                    presenter.onClickButton(R.drawable.image, text, getApplicationContext());
                }
            }
        }
    }

    public void onButtonLongClick(View view) {
        removeAllItem();
    }

    private void removeAllItem() {
        if (!itemList.isEmpty()) {
            itemList.clear();
            testImageViewFragment.removeAll();
            showToast(R.string.fragment_clear_toast);
        } else {
            showToast(R.string.fragment_empty_toast);
        }
    }
}