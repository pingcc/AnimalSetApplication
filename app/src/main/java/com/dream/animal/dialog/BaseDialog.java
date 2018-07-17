package com.dream.animal.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import butterknife.ButterKnife;


/**
 * Created on 2017/6/28.
 * @author chen_ping
 * Email yy_cping@163.com
 * Edit androidStudio
 */

public abstract class BaseDialog extends Dialog implements DialogAction {


    public BaseDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }



    /**
     * 当dialog 第一次初始化时调用show方法时调用
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setWindowAttribute();
        setContentView(getLayoutId());
        setCanceledOnTouchOutside(true);//点击外部取消对话框

        ButterKnife.bind(this);

        initDialogData();

    }

    protected void setWindowAttribute() {
        Window window = super.getWindow();
        if (window != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams params = window.getAttributes();
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            params.gravity = Gravity.CENTER;
            window.setAttributes(params);
        }
    }


}
