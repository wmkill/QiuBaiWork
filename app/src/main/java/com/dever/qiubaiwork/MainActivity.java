package com.dever.qiubaiwork;

import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.dever.qiubaiwork.fragments.ExploreFragment;
import com.dever.qiubaiwork.fragments.FriendGroupFragment;
import com.dever.qiubaiwork.fragments.QiushiFragment;
import com.dever.qiubaiwork.fragments.ZhitiaoFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private SlidingPaneLayout drawerLayout;
    private FrameLayout frameLayout;
    private NavigationView menu;
    private Fragment qiushiFragment,friendGroupFragment,exploreFragment,zhitiaoFragment;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (SlidingPaneLayout) findViewById(R.id.drawer);
        frameLayout = (FrameLayout) findViewById(R.id.frame);

        qiushiFragment = new QiushiFragment();
        friendGroupFragment = new FriendGroupFragment();
        exploreFragment = new ExploreFragment();
        zhitiaoFragment = new ZhitiaoFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frame, qiushiFragment);
        transaction.commit();
        menu = (NavigationView)findViewById(R.id.menu);
        menu.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        item.setChecked(true);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (item.getItemId()){
            case R.id.qiushi:
                transaction.replace(R.id.frame,qiushiFragment);
                break;
            case R.id.friendGroup:
                transaction.replace(R.id.frame,friendGroupFragment);
                break;
            case R.id.explore:
                transaction.replace(R.id.frame,exploreFragment);
                break;
            case R.id.zhitiao:
                transaction.replace(R.id.frame,zhitiaoFragment);
                break;
            case R.id.out:
                ActivityCompat.finishAffinity(this);
                break;
        }
        transaction.commit();
        drawerLayout.closePane();
        return false;
    }
}
