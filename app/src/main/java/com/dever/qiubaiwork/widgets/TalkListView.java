package com.dever.qiubaiwork.widgets;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.IPullToRefresh;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

/**
 * Created by admin on 2015/12/30.
 */
public class TalkListView extends ListView implements IPullToRefresh {

    public TalkListView(Context context) {
        super(context);
    }

    public TalkListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean demo() {
        return false;
    }

    @Override
    public PullToRefreshBase.Mode getCurrentMode() {
        return null;
    }

    @Override
    public boolean getFilterTouchEvents() {
        return false;
    }

    @Override
    public ILoadingLayout getLoadingLayoutProxy() {
        return null;
    }

    @Override
    public ILoadingLayout getLoadingLayoutProxy(boolean includeStart, boolean includeEnd) {
        return null;
    }

    @Override
    public PullToRefreshBase.Mode getMode() {
        return null;
    }

    @Override
    public View getRefreshableView() {
        return null;
    }

    @Override
    public boolean getShowViewWhileRefreshing() {
        return false;
    }

    @Override
    public PullToRefreshBase.State getState() {
        return null;
    }

    @Override
    public boolean isPullToRefreshEnabled() {
        return false;
    }

    @Override
    public boolean isPullToRefreshOverScrollEnabled() {
        return false;
    }

    @Override
    public boolean isRefreshing() {
        return false;
    }

    @Override
    public boolean isScrollingWhileRefreshingEnabled() {
        return false;
    }

    @Override
    public void onRefreshComplete() {

    }

    @Override
    public void setFilterTouchEvents(boolean filterEvents) {

    }

    @Override
    public void setMode(PullToRefreshBase.Mode mode) {

    }

    @Override
    public void setOnPullEventListener(PullToRefreshBase.OnPullEventListener listener) {

    }

    @Override
    public void setOnRefreshListener(PullToRefreshBase.OnRefreshListener listener) {

    }

    @Override
    public void setOnRefreshListener(PullToRefreshBase.OnRefreshListener2 listener) {

    }

    @Override
    public void setPullToRefreshOverScrollEnabled(boolean enabled) {

    }

    @Override
    public void setRefreshing() {

    }

    @Override
    public void setRefreshing(boolean doScroll) {

    }

    @Override
    public void setScrollAnimationInterpolator(Interpolator interpolator) {

    }

    @Override
    public void setScrollingWhileRefreshingEnabled(boolean scrollingWhileRefreshingEnabled) {

    }

    @Override
    public void setShowViewWhileRefreshing(boolean showView) {

    }


    /*@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>1,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }*/
}
