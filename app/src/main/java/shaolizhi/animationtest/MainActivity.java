package shaolizhi.animationtest;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * 本Activity展现了逐帧动画和补间动画
 */
public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    private boolean isAlphaZero;
    private boolean isScaleZero;
    private boolean isTranslateZero;
    private boolean isRotateZero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image_view);
//
        //逐帧动画
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();

        isAlphaZero = false;
        isScaleZero = false;
        isTranslateZero = false;
        isRotateZero = false;
//        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale);
//        animation.setFillAfter(true);
//        imageView.startAnimation(animation);

    }

    public void changeAlpha(View view) {
        if (isAlphaZero) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);//初始化操作，参数传入0和1，即由透明度0变化到透明度为1
            imageView.startAnimation(alphaAnimation);//开始动画
            alphaAnimation.setFillAfter(true);//动画结束后保持状态
            alphaAnimation.setDuration(1000);//动画持续时间，单位为毫秒
            isAlphaZero = false;//标识位
        } else {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);//初始化操作，参数传入1和0，即由透明度1变化到透明度为0
            imageView.startAnimation(alphaAnimation);//开始动画
            isAlphaZero = true;//标识位
            alphaAnimation.setFillAfter(true);//动画结束后保持状态
            alphaAnimation.setDuration(1000);//动画持续时间
        }
    }

    public void changeScale(View view) {
        if (isScaleZero) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f,
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            scaleAnimation.setDuration(1000);
            scaleAnimation.setFillAfter(true);
            isScaleZero = false;
            imageView.startAnimation(scaleAnimation);

        } else {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            scaleAnimation.setDuration(1000);
            scaleAnimation.setFillAfter(true);
            isScaleZero = true;
            imageView.startAnimation(scaleAnimation);
        }
    }

    public void changeTranslate(View view) {
        if (isTranslateZero) {
            isTranslateZero = false;
            TranslateAnimation translateAnimation = new TranslateAnimation(200, 0, 200, 0);
            translateAnimation.setDuration(1000);
            translateAnimation.setFillAfter(true);
            imageView.startAnimation(translateAnimation);
        } else {
            isTranslateZero = true;
            TranslateAnimation translateAnimation = new TranslateAnimation(0, 200, 0, 200);
            translateAnimation.setDuration(1000);
            translateAnimation.setFillAfter(true);
            imageView.startAnimation(translateAnimation);

        }
    }

    public void changeRotate(View view) {
        if (isRotateZero) {
            isRotateZero = false;
            RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setDuration(1000);
            imageView.startAnimation(rotateAnimation);
        } else {
            isRotateZero = true;
            RotateAnimation rotateAnimation = new RotateAnimation(360, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setDuration(1000);
            imageView.startAnimation(rotateAnimation);
        }
    }

    public void openSecondActivity(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
}
