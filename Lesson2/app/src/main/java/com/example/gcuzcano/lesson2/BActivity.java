package com.example.gcuzcano.lesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Button buttonC = (Button) findViewById(R.id.button);
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BActivity.this, CActivity.class);
                startActivity(intent);
            }
        });
        Button buttonD = (Button) findViewById(R.id.button2);
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BActivity.this, DActivity.class);
                startActivity(intent);
            }
        });
        Button buttonE = (Button) findViewById(R.id.button3);
        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BActivity.this, EActivity.class);
                startActivity(intent);
            }
        });
    }
}
