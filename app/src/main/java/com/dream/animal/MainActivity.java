package com.dream.animal;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;

import com.dream.animal.dialog.SelectDialog;

/**
 * Created  on 2018/1/16.
 *
 * @author CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */
public class MainActivity extends AppCompatActivity {

    private Button mBtAdd;
    private SelectDialog selectDialog;
    private FrameLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = findViewById(R.id.fl_content);
        mBtAdd = findViewById(R.id.bt_add);
        selectDialog = new SelectDialog(this);

        mBtAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectDialog.show();
            }
        });
        selectDialog.setTitleText("I am title").setSubtitleText("I am a custom content").
                setLeftClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        selectDialog.dismiss();
                    }
                }).setRightClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addShopCar();
                selectDialog.dismiss();
            }
        });

    }

    private  View mView;
    public void addShopCar(){
         mView = View.inflate(this, R.layout.dialog_select, null);
        mainLayout.addView(mView);
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mView.getLayoutParams();
        params.width = (UiUtils.getScreenWidth() - (int) (UiUtils.dp2px(100) + 0.5));

        params.height = (int) (UiUtils.dp2px(150) + 0.5);

        params.gravity = Gravity.CENTER;
        params.bottomMargin = (int) (UiUtils.dp2px(45) + 0.5);
        mView.setLayoutParams(params);

        ObjectAnimator animatorScaleX = ObjectAnimator.ofFloat(mView, "scaleX", 1.0f, 0.1f);
        ObjectAnimator animatorScaleY = ObjectAnimator.ofFloat(mView, "scaleY", 1.0f, 0.1f);

        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mView, "translationY", 0, UiUtils.getScreenHeight() / 2 - (int) (UiUtils.dp2px(25) + 0.5));
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mView, "translationX", 0, -(UiUtils.getScreenWidth() / 2 - (int) (UiUtils.dp2px(20) + 0.5)));
        ObjectAnimator animatorRotation = ObjectAnimator.ofFloat(mView, "rotation", 0, 720);
        AnimatorSet set = new AnimatorSet();

        animatorScaleX.setInterpolator(new LinearInterpolator());
        animatorScaleY.setInterpolator(new LinearInterpolator());

        set.play(animatorX).with(animatorY).with(animatorRotation).after(animatorScaleX).after(animatorScaleY);
        //    set.playTogether(animatorX, animatorY, animatorRotation, animatorScaleX, animatorScaleY);
        set.setDuration(250);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (mView != null)
                    mainLayout.removeView(mView);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
