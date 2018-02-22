package com.q.testdummy.vo;

import com.q.testdummy.imageview.TestImageViewAdapterContract;

public class TestImageViewVo implements TestImageViewAdapterContract.Model {
    private int image;
    private String text;

    @Override
    public int getImage() {
        return image;
    }

    @Override
    public void setImage(int image) {
        this.image = image;
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