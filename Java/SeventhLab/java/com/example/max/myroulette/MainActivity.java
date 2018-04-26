package com.example.max.myroulette;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    ImageView iv_ruletka;

    Random r;

    int degree = 0, degree_old = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button2); //чтобы обратится к константе нужно написать R.id.myText
        textView = (TextView) findViewById(R.id.textView); //findVievByID возвращает по ID - View
        iv_ruletka = (ImageView) findViewById(R.id.iv_ruletka);

        r = new Random();

        button.setOnClickListener(new View.OnClickListener() {  //setOnClickListener регирование кнопки на нажатие
            @Override
            public void onClick(View v) {
                degree_old = degree % 360;
                degree = r.nextInt(3600) + 720;
                RotateAnimation rotate = new RotateAnimation(degree_old,degree,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(3600); //Как долго эта анимация должна продолжаться.
                rotate.setFillAfter(true); //Если fillAfter имеет значение true, преобразование, которое выполняет эта анимация, сохранится, когда оно будет завершено.
                rotate.setInterpolator(new DecelerateInterpolator()); //Устанавливает кривую ускорения для этой анимации.
                rotate.setAnimationListener(new Animation.AnimationListener() { //Привязывает анимацию к этой анимации.
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                iv_ruletka.startAnimation(rotate);
            }
        });
    }
}
