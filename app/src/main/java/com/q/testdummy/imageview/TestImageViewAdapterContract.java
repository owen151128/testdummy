package com.q.testdummy.imageview;

import android.graphics.drawable.BitmapDrawable;

import com.q.testdummy.vo.TestImageViewVo;

import java.util.ArrayList;

public interface TestImageViewAdapterContract {

    interface View {

        void refresh();

        void setList(ArrayList<TestImageViewVo> items);

        void add(TestImageViewVo vo);

        void removeAll();
    }

    interface Model {

        BitmapDrawable getDrawable();

        void setDrawable(BitmapDrawable image);

        String getText();

        void setText(String text);
    }
}