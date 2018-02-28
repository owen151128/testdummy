package com.q.testdummy.imageview;

import android.graphics.drawable.BitmapDrawable;

public interface TestImageViewAdapterContract {

    interface View {

        void refresh();
    }

    interface Model {

        BitmapDrawable getDrawable();

        void setDrawable(BitmapDrawable image);

        String getText();

        void setText(String text);
    }
}