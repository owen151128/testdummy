package com.q.testdummy;

import android.content.Context;

import com.q.testdummy.vo.TestImageViewVo;

public interface MainContract {

    interface View {

        void showToast(String text);

        void showToast(int resourceId);

        void addItem(TestImageViewVo vo);

    }

    interface Presenter {

        void onClickButton(int imageId, String text, Context context);

    }
}