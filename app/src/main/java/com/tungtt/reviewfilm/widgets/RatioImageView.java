package com.tungtt.reviewfilm.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.makeramen.roundedimageview.RoundedImageView;
import com.tungtt.reviewfilm.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by tungthanh1497 a.k.a TungTT
 * On Wed, 15 Apr 2020 - 11:05
 * <p>
 * Custom image view which can be calculate to keep ratio follow by design
 */
public class RatioImageView extends RoundedImageView {

    @Retention(RetentionPolicy.SOURCE)
    public @interface TYPE_FIXED_DIMENSIONAL {
        int WIDTH = 0;
        int HEIGHT = 1;
    }

    private float mRatioWidth = 0;
    private float mRatioHeight = 0;
    private boolean mIsFixedWidth = true;

    public RatioImageView(Context context) {
        super(context);
        loadValues(context, null);
    }

    public RatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        loadValues(context, attrs);
    }

    public RatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        loadValues(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (mRatioWidth * mRatioHeight > 0) {
            float ratio = mRatioWidth / mRatioHeight;
            int width, height;
            if (mIsFixedWidth) {
                width = getMeasuredWidth();
                height = Math.round(width / ratio);
            } else {
                height = getMeasuredHeight();
                width = Math.round(height * ratio);
            }
            setMeasuredDimension(width, height);
        }

    }

    /**
     * set fixed dimensional programmatically
     *
     * @param fixedDimensional: dimensional which be fixed
     */
    public void setFixedDimensional(@TYPE_FIXED_DIMENSIONAL int fixedDimensional) {
        mIsFixedWidth = (TYPE_FIXED_DIMENSIONAL.WIDTH == fixedDimensional);
        requestLayout();
    }

    private void loadValues(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RatioImageView);
            mRatioWidth = typedArray.getFloat(R.styleable.RatioImageView_ratio_width, 0);
            mRatioHeight = typedArray.getFloat(R.styleable.RatioImageView_ratio_height, 0);
            mIsFixedWidth = (TYPE_FIXED_DIMENSIONAL.WIDTH == typedArray.getInteger(R.styleable.RatioImageView_fixed_dimensional, TYPE_FIXED_DIMENSIONAL.WIDTH));
            typedArray.recycle();
        }
    }
}
