package com.cs.test_viewpage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/9/19/019.
 */

public class HomeFragment4 extends BasePersonFragment {
    private View mViewContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        initView();
        //view = inflater.inflate(R.layout.fragment1, container, false);

        if (mViewContent == null) {
            mViewContent = inflater.inflate(R.layout.fragment4, container, false);
        }

        // 缓存View判断是否含有parent, 如果有需要从parent删除, 否则发生已有parent的错误.
        ViewGroup parent = (ViewGroup) mViewContent.getParent();
        if (parent != null) {
            parent.removeView(mViewContent);
        }

        return mViewContent;

    }





    @Override
    public View initView() {
        return mViewContent;
    }

    @Override
    public void initData() {

    }
}
