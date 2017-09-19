package com.cs.test_viewpage;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ViewPager mVpAcLook;
    private List<String> titles = new ArrayList<>();
    private List<Fragment> list = new ArrayList<>();
    private ViewPagerAdater adater;
    private TextView mTvAcLookSave;
    private TabLayout mTabAcLook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }


    private void initView() {
        mTvAcLookSave = (TextView) findViewById(R.id.tv_ac_look_save);
        mVpAcLook = (ViewPager) findViewById(R.id.vp_ac_look);
        mTabAcLook = (TabLayout) findViewById(R.id.tab_ac_look);

        titles.add("全部");
        titles.add("待确认");
        titles.add("待完成");
        titles.add("待评价");
        titles.add("已完成");
        for (int i = 0; i < titles.size(); i++) {
            mTabAcLook.addTab(mTabAcLook.newTab().setTag(titles.get(i)));
        }
        list.add(new HomeFragment1());
        list.add(new HomeFragment2());
        list.add(new HomeFragment3());
        list.add(new HomeFragment4());
        list.add(new HomeFragment5());

        adater = new ViewPagerAdater(getSupportFragmentManager(), list, titles);
        mVpAcLook.setAdapter(adater);
        mTabAcLook.post(new Runnable() {
            @Override
            public void run() {
                mTabAcLook.setupWithViewPager(mVpAcLook);
            }
        });
        mTabAcLook.setTabsFromPagerAdapter(adater);

    }

    class ViewPagerAdater extends FragmentStatePagerAdapter {
        public List<Fragment> mFragments;
        public List<String> mTitles;

        public ViewPagerAdater(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
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
