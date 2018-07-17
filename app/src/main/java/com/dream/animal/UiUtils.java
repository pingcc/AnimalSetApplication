package com.dream.animal;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created on 2017/6/26.
 * author chen_ping
 * Email yy_cping@163.com
 * Edit androidStudio
 */

public class UiUtils {



    /**
     * dp转px
     */
    public static float dp2px(float value) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getDisplayMetrics());
    }

    /*获取屏幕的宽*/
    public static int getScreenWidth() {
        return getDisplayMetrics().widthPixels;
    }

    /*获取屏幕的高*/
    public static int getScreenHeight() {
        return getDisplayMetrics().heightPixels;
    }
    /**
     * 获取屏幕信息
     */
    public static DisplayMetrics getDisplayMetrics() {
        return Resources.getSystem().getDisplayMetrics();
    }


}
