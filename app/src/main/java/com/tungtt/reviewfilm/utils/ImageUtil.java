package com.tungtt.reviewfilm.utils;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by tungtt a.k.a TungTT
 * On Tue, 10 Nov 2020 - 16:36
 */
public class ImageUtil {

    @Retention(RetentionPolicy.SOURCE)
    private @interface SIZE_IMAGE {
        String W94_H141 = "https://image.tmdb.org/t/p/w94_and_h141_bestv2/";
        String W300_H450 = "https://image.tmdb.org/t/p/w300_and_h450_bestv2/";
        String W600_H900 = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/";
    }

    public static void loadImage(@SIZE_IMAGE String domain, String url, ImageView imageView) {
        Picasso.get().load(domain + url).into(imageView);
    }
}
