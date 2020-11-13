package com.tungtt.reviewfilm.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by tungtt a.k.a TungTT
 * On Thu, 05 Nov 2020 - 12:01
 */
public class Constant {
    @Retention(RetentionPolicy.SOURCE)
    public @interface SCREEN_TAG {
        String MAIN = "main";
        String DETAIL_MOVIE = "detail";
    }
}
