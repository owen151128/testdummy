package com.q.testdummy.imageview;

public interface TestImageViewAdapterContract {

    interface View {

        void refresh();
    }

    interface Model {

        int getImage();

        void setImage(int image);

        String getText();

        void setText(String text);
    }
}
