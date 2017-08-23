package shaolizhi.animationtest;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * 本Activity展现了属性动画
 */
public class SecondActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        imageView = (ImageView) findViewById(R.id.image_view);
    }

    public void objectAnimatorClick(View view) {
        ObjectAnimator//
                .ofFloat(view, "rotationX", 0.0F, 360.0F)//
                .setDuration(500)//
                .start();
    }

    public void imageViewClick(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.scale_animator);
        animator.setTarget(imageView);
        animator.start();
    }


}
