package com.cs.test_viewpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/9/19/019.
 */

public class TestFragment1 extends BasePersonFragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        initView();

        view = inflater.inflate(R.layout.test1, container, false);

        return view;
    }

    @Override
    public View initView() {
        return view;
    }

    @Override
    public void initData() {
        Toast.makeText(mContext, "1", Toast.LENGTH_SHORT).show();

    }
}
