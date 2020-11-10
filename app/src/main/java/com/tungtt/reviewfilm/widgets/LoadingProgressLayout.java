package com.tungtt.reviewfilm.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.tungtt.reviewfilm.R;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 15:24
 */
public class LoadingProgressLayout extends LinearLayout {
    View loaderCircle;
    int delta = 10;
    boolean check = true;
    boolean stopAnimation = false;
    Animation rotation, animationOut;
    Animation.AnimationListener listener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            rotation.cancel();
            setVisibility(GONE);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    public LoadingProgressLayout(Context context) {
        super(context);
        rotation = AnimationUtils.loadAnimation(context, R.anim.rotate_repeat);
        animationOut = AnimationUtils.loadAnimation(context, R.anim.progress_out);
        animationOut.setAnimationListener(listener);
        inflate(context, R.layout.layout_loading_progress, this);
        loaderCircle = findViewById(R.id.loader_circle);
        loaderCircle.setRotationX(180);
        runAnimation();
    }

    public LoadingProgressLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        rotation = AnimationUtils.loadAnimation(context, R.anim.rotate_repeat);
        animationOut = AnimationUtils.loadAnimation(context, R.anim.progress_out);
        animationOut.setAnimationListener(listener);
        inflate(context, R.layout.layout_loading_progress, this);
        loaderCircle = findViewById(R.id.loader_circle);
        loaderCircle.setRotationX(180);
        runAnimation();
    }

    public LoadingProgressLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        rotation = AnimationUtils.loadAnimation(context, R.anim.rotate_repeat);
        animationOut = AnimationUtils.loadAnimation(context, R.anim.progress_out);
        animationOut.setAnimationListener(listener);
        inflate(context, R.layout.layout_loading_progress, this);
        loaderCircle = findViewById(R.id.loader_circle);
        loaderCircle.setRotationX(180);
        runAnimation();
    }

    private void runAnimation() {
        loaderCircle.startAnimation(rotation);
    }

    public void startAnimationOut() {
        startAnimation(animationOut);
    }

    public void stopAnimation() {
        stopAnimation = true;
    }

    public void startAnimation() {
        stopAnimation = false;
        runAnimation();
    }

    @Override
    public void setVisibility(int visibility) {
        if (visibility == VISIBLE) {
            super.setVisibility(visibility);
            stopAnimation = false;
            runAnimation();
        } else {
            if (stopAnimation) {
                super.setVisibility(visibility);
            } else {
                stopAnimation = true;
                startAnimationOut();
            }
        }
    }
}