package com.q.testdummy.imageview;

import com.q.testdummy.vo.TestImageViewVo;

public interface TestImageViewContract {

    interface View {

        void add(TestImageViewVo vo);

        void removeAll();
    }

    interface Presenter {

    }

}