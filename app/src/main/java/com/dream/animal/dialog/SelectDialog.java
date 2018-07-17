package com.dream.animal.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dream.animal.FastClickUtils;
import com.dream.animal.R;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created  on 2018/1/16.
 * @author  CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */

public class SelectDialog extends BaseDialog {

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_subtitle)
    TextView mTvSubtitle;
    @BindView(R.id.btn_left)
    Button mBtnLeft;
    @BindView(R.id.btn_right)
    Button mBtnRight;

    private String mTitle;
    private String mLeftText;
    private String mRightText;

    private View.OnClickListener mLeftClick;
    private View.OnClickListener mRightClick;
    private String mSubtitle;
    private boolean mShowLeftBtn;
    private boolean mShowRightBtn;


    private int mRightBtnTextColor = 0;
    private int mTitleTextColor = 0;
    private int mLeftBtnTextColor = 0;

    public SelectDialog(@NonNull Context context) {
        this(context, true, true);
    }

    public SelectDialog(@NonNull Context context, boolean showLeftBtn, boolean showRightBtn) {
        super(context, R.style.SelectStyle);
        mShowLeftBtn = showLeftBtn;
        mShowRightBtn = showRightBtn;
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialog_select;
    }

    @Override
    public void initDialogData() {//show 之后调用，控件已注入
        if (!TextUtils.isEmpty(mTitle))
            mTvTitle.setText(mTitle);
        if (!TextUtils.isEmpty(mLeftText))
            mBtnLeft.setText(mLeftText);
        if (!TextUtils.isEmpty(mRightText))
            mBtnRight.setText(mRightText);
        if (!TextUtils.isEmpty(mSubtitle))
            mTvSubtitle.setText(mSubtitle);

        // 是否显示左边和右边按钮
        mBtnLeft.setVisibility(mShowLeftBtn ? View.VISIBLE : View.GONE);
        mBtnRight.setVisibility(mShowRightBtn ? View.VISIBLE : View.GONE);

        int titleColor = mTitleTextColor == 0 ? ContextCompat.getColor(getContext(), R.color.color_999) : mTitleTextColor;
        mTvTitle.setTextColor(titleColor);

        // 左边和右边按钮文字
        int leftTextColor = mLeftBtnTextColor == 0 ? ContextCompat.getColor(getContext(), R.color.color_333) : mLeftBtnTextColor;

        mBtnLeft.setTextColor(leftTextColor);
        int rightTextColor = mRightBtnTextColor == 0 ? ContextCompat.getColor(getContext(), R.color.color_toolbar) : mRightBtnTextColor;
        mBtnRight.setTextColor(rightTextColor);
    }


    @OnClick({R.id.btn_left, R.id.btn_right})
    public void onViewClicked(View view) {
        cancel();
        if (FastClickUtils.getInstance().isFastClick()) {
            return;
        }
        switch (view.getId()) {
            case R.id.btn_left:
                if (mLeftClick != null) {
                    mLeftClick.onClick(view);
                }

                break;
            case R.id.btn_right:
                if (mRightClick != null) {
                    mRightClick.onClick(view);
                }
                break;
        }
    }


    public SelectDialog setTitleText(String title) {
        if (mTvTitle != null) {
            mTvTitle.setText(title);
        }
        this.mTitle = title;
        return this;
    }

    public SelectDialog setTitleText(@StringRes int stingRes) {
        if (mTvTitle != null) {
            mTvTitle.setText(stingRes);
        }
        this.mTitle = getContext().getString(stingRes);
        return this;
    }

    public SelectDialog setTitleTextColor(int titleTextColor) {
        mTitleTextColor = titleTextColor;
        return this;
    }

    public SelectDialog setSubtitleText(@StringRes int stingRes) {
        if (mTvSubtitle != null) {
            mTvSubtitle.setText(stingRes);
        }
        this.mSubtitle = getContext().getString(stingRes);
        return this;
    }

    public SelectDialog setSubtitleText(String title) {
        if (mTvSubtitle != null) {
            mTvSubtitle.setText(title);
        }
        this.mSubtitle = title;
        return this;
    }


    public SelectDialog setLeftText(String title) {
        if (mBtnLeft != null) {
            mBtnLeft.setText(title);
        }
        this.mLeftText = title;
        return this;
    }

    public SelectDialog setLeftText(@StringRes int stingRes) {
        if (mBtnLeft != null) {
            mBtnLeft.setText(stingRes);
        }
        this.mLeftText = getContext().getString(stingRes);
        return this;
    }

    public SelectDialog setRightText(String title) {
        if (mBtnRight != null) {
            mBtnRight.setText(title);
        }
        this.mRightText = title;
        return this;
    }

    public SelectDialog setRightText(@StringRes int stingRes) {
        if (mBtnRight != null) {
            mBtnRight.setText(stingRes);
        }
        this.mRightText = getContext().getString(stingRes);
        return this;
    }

    public SelectDialog setLeftClickListener(View.OnClickListener onClickListener) {

        this.mLeftClick = onClickListener;
        return this;
    }

    public SelectDialog setRightClickListener(View.OnClickListener onClickListener) {

        this.mRightClick = onClickListener;
        return this;
    }


    public SelectDialog setLeftBtnTextColor(int leftBtnTextColor) {
        mLeftBtnTextColor = leftBtnTextColor;
        return this;
    }


    public SelectDialog setRightBtnTextColor(int rightTextColor) {
        mRightBtnTextColor = rightTextColor;
        return this;
    }


}
