package com.example.gcuzcano.lesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private static final int maxValue = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LinearLayout layout = (LinearLayout) findViewById(R.id.main_activity);

        View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BActivity.class);
                startActivity(intent);
            }
        };

        for (int i = 0; i < maxValue; i++) {
            ImageView image = new ImageView(this);
            image.setImageResource(R.drawable.ghost);
            image.setOnClickListener(onClick);
            layout.addView(image);
        }
    }
}
