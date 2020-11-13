package com.tungtt.reviewfilm.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tungtt a.k.a TungTT
 * On Fri, 13 Nov 2020 - 15:26
 */
public class CommonUtil {
    public static boolean isNullOrEmpty(Object object) {
        if (object == null) {
            return true;
        } else if (object instanceof String) {
            return 0 == ((String) object).trim().length();
        } else if (object instanceof ArrayList) {
            return 0 == ((ArrayList) object).size();
        } else if (object instanceof List) {
            return 0 == ((List) object).size();
        } else {
            return false;
        }
    }
}
