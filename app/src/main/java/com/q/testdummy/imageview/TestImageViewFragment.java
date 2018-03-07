package com.q.testdummy.imageview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.q.testdummy.databinding.TestImageViewBinding;
import com.q.testdummy.vo.TestImageViewVo;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.ArrayList;

public class TestImageViewFragment extends RxFragment implements TestImageViewContract.View {

    private TestImageViewBinding binding;
    private TestImageViewAdapter adapter;

    public TestImageViewFragment() {
    }

    public static TestImageViewFragment newInstance() {
        return new TestImageViewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ArrayList<TestImageViewVo> vo = new ArrayList<>();
        adapter = new TestImageViewAdapter(vo);
        binding = TestImageViewBinding.inflate(inflater, container, false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        binding.testImageView.setLayoutManager(layoutManager);
        binding.testImageView.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void add(TestImageViewVo vo) {
        adapter.add(vo);
        adapter.refresh();
    }

    @Override
    public void removeAll() {
        adapter.removeAll();
        adapter.refresh();
    }
}