package com.dever.qiubaiwork.fragmentadapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dever.qiubaiwork.fragments.QiushiFragment;

import java.util.List;

/**
 * Created by admin on 2015/12/28.
 */
public class CommonFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;

    public CommonFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getArguments().getString("name");
    }
}
