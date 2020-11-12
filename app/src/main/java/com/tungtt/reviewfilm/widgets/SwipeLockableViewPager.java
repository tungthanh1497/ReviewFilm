package com.tungtt.reviewfilm.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by tungtt a.k.a TungTT
 * On Thu, 12 Nov 2020 - 13:11
 */
public class SwipeLockableViewPager extends ViewPager {

    private boolean isLocked = true;

    public SwipeLockableViewPager(@NonNull Context context) {
        super(context);
    }

    public SwipeLockableViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean canScrollHorizontally(int direction) {
        return !isLocked && super.canScrollHorizontally(direction);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return !isLocked && super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return !isLocked && super.onTouchEvent(ev);
    }

    public void setLockSwipe(boolean isLocked) {
        this.isLocked = isLocked;
    }
}
