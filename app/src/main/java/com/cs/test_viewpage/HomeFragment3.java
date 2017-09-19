package com.cs.test_viewpage;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/19/019.
 */

public class HomeFragment3 extends BasePersonFragment {
    private TabLayout mTabLook;
    private ViewPager mVpLook;


    private ViewPagerFmAdater adater;
    private View mViewContent;
    private List<String> titles;
    private List<Fragment> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        initView();
        mViewContent = inflater.inflate(R.layout.fragment3, container, false);

        if (mViewContent == null) {
            mViewContent = inflater.inflate(R.layout.fragment4, container, false);
        }

        // 缓存View判断是否含有parent, 如果有需要从parent删除, 否则发生已有parent的错误.
        ViewGroup parent = (ViewGroup) mViewContent.getParent();
        if (parent != null) {
            parent.removeView(mViewContent);
        }

        initView(mViewContent);
        return mViewContent;


    }



    @Override
    public View initView() {
        return mViewContent;
    }

    @Override
    public void initData() {





    }

    private void initView(View view) {
        mTabLook = (TabLayout) view.findViewById(R.id.tab_look);
        mVpLook = (ViewPager) view.findViewById(R.id.vp_look);
        titles = new ArrayList<>();
        list = new ArrayList<>();
        titles.add("高手1");
        titles.add("高手2");
        titles.add("高手3");
        titles.add("高手4");

        for (int i = 0; i < titles.size(); i++) {
            mTabLook.addTab(mTabLook.newTab().setTag(titles.get(i)));
        }
        list.add(new TestFragment1());
        list.add(new TestFragment2());
        list.add(new TestFragment3());
        list.add(new TestFragment4());

        adater = new ViewPagerFmAdater(getChildFragmentManager(), list, titles);
        mVpLook.setAdapter(adater);
        mTabLook.post(new Runnable() {
            @Override
            public void run() {
                mTabLook.setupWithViewPager(mVpLook);
            }
        });
        mTabLook.setTabsFromPagerAdapter(adater);




    }

    class ViewPagerFmAdater extends FragmentStatePagerAdapter {
        public List<Fragment> mFragments;
        public List<String> mTitles;

        public ViewPagerFmAdater(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
            super(fm);
            mFragments = fragments;
            mTitles = titles;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }

        public int getItemPosition(Object object) {
            // TODO Auto-generated method stub
            return PagerAdapter.POSITION_NONE;
        }

    }
}
