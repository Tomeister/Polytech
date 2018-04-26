package com.example.max.sixthlab;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageView imageView;
    ImageView imageView2;
    View view1;
    View view2;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        r = new Random();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color1 = Color.argb(255,r.nextInt(256), r.nextInt(256), r.nextInt(256));
                imageView.setColorFilter(color1);
                int x1 = 1 + r.nextInt(3);
                imageView.setScaleX(x1);
                imageView.setScaleY(x1);

                int color2 = Color.argb(255,r.nextInt(256), r.nextInt(256), r.nextInt(256));
                imageView2.setColorFilter(color2);
                int x2 = 1 + r.nextInt(3);
                imageView2.setScaleX(x2);
                imageView2.setScaleY(x2);

                }
        });
    }
}