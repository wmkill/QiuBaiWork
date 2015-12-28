package com.dever.qiubaiwork.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dever.qiubaiwork.R;
import com.dever.qiubaiwork.fragmentadapters.CommonFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class QiushiFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    public QiushiFragment() {
        // Required empty public constructor
    }

    public static QiushiFragment newInstance(String str) {

        Bundle args = new Bundle();

        QiushiFragment fragment = new QiushiFragment();
        args.putString("str", str);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_qiushi, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        String[] str = {"专享","视频","纯文","纯图","精华","最新"};
        List<Fragment> fragments = new ArrayList<>();
        for(String s:str) {
            ArticleFragment f = new ArticleFragment();
            Bundle bundle = new Bundle();
            bundle.putString("name",s);
            f.setArguments(bundle);
            fragments.add(f);
        }
        CommonFragmentPagerAdapter adapter = new CommonFragmentPagerAdapter(getChildFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
