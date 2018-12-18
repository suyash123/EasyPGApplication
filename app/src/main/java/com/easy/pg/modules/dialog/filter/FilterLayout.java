package com.easy.pg.modules.dialog.filter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FilterLayout extends FrameLayout{

    FrameLayout frameLayout;
    FloatingActionButton floatingActionButton;

    public FilterLayout(Context context) {
        super(context);
        init();
    }

    public FilterLayout(Context context,  AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public FilterLayout(Context context,  AttributeSet attrs,  int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FilterLayout(  Context context,  AttributeSet attrs,  int defStyleAttr,  int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();

    }

    public void init() {
        frameLayout = new FrameLayout(getContext());
        frameLayout.setTag(FilterConstants.FILTER_FL_TAG);
        floatingActionButton = new FloatingActionButton(getContext());
        floatingActionButton.setTag(FilterConstants.FILTER_FAB_TAG);
        floatingActionButton.setCompatElevation(0);
        frameLayout.addView(floatingActionButton);
        this.addView(frameLayout);

    }
}
