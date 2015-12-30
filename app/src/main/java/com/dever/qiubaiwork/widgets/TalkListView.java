package com.dever.qiubaiwork.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by admin on 2015/12/30.
 */
public class TalkListView extends ListView {

    public TalkListView(Context context) {
        super(context);
    }

    public TalkListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>1,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
}
