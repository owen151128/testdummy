package com.q.testdummy;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;

import com.q.testdummy.vo.TestImageViewVo;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void onClickButton(int imageId, String text, Context context) {
        TestImageViewVo vo = new TestImageViewVo((BitmapDrawable) ContextCompat.getDrawable(context,
                imageId), text);
        view.addItem(vo);
    }
}