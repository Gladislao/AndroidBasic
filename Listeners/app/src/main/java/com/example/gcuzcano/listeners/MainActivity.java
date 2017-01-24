package com.example.gcuzcano.listeners;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}";
    private EditText username;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        Button button = (Button) findViewById(R.id.button);

        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    login();
                    return true;
                }
                return false;
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    private void login() {
        if (fieldsValidation()) {
            startActivity(new Intent(MainActivity.this, DashboardActivity.class));
            Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean fieldsValidation() {
        if (!validEmail()) {
            Toast.makeText(this, "Invalid mail", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!validPassword()) {
            Toast.makeText(this, "Invalid password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean validEmail() {
        return !TextUtils.isEmpty(username.getText()) && Patterns.EMAIL_ADDRESS.matcher(username.getText()).matches();
    }

    private boolean validPassword() {
        return !TextUtils.isEmpty(password.getText()) && password.getText().toString().matches(PASSWORD_REGEX);
    }


}
