package com.q.testdummy.vo;

import android.graphics.drawable.BitmapDrawable;

import com.q.testdummy.imageview.TestImageViewAdapterContract;

public class TestImageViewVo implements TestImageViewAdapterContract.Model {
    private BitmapDrawable drawable;
    private String text;

    public TestImageViewVo(BitmapDrawable drawable, String text) {
        this.drawable = drawable;
        this.text = text;
    }

    @Override
    public BitmapDrawable getDrawable() {
        return drawable;
    }

    @Override
    public void setDrawable(BitmapDrawable image) {
        this.drawable = image;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}