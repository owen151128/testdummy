package com.q.testdummy.imageview;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.q.testdummy.R;
import com.q.testdummy.databinding.TestImageViewBinding;
import com.q.testdummy.vo.TestImageViewVo;

import java.util.ArrayList;

public class TestImageViewAdapter extends RecyclerView.Adapter<TestImageViewAdapter.ViewHolder> {
    private ArrayList<TestImageViewVo> voList;

    public TestImageViewAdapter(ArrayList<TestImageViewVo> items) {
        this.voList = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        TestImageViewBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.test_image_view, viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        TestImageViewVo vo = voList.get(i);
        viewHolder.bind(vo);
    }

    @Override
    public int getItemCount() {
        return voList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TestImageViewBinding mBinding;

        private ViewHolder(TestImageViewBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        private void bind(@NonNull TestImageViewVo vo) {
            mBinding.setVo(vo);
            mBinding.executePendingBindings();
        }
    }
}