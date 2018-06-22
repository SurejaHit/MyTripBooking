package com.example.surejahit.mytripbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

     EditText emiladd,pass;

     String Emailid,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        emiladd = (EditText) findViewById(R.id.email1);
        pass = (EditText) findViewById(R.id.passw);
        Button signup = findViewById(R.id.btn12);
        Button login = findViewById(R.id.btn11);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Emailid = emiladd.getText().toString();
                password = pass.getText().toString();
                String method = "Login";
                BackgroundTask b2 = new BackgroundTask(LoginActivity.this);
                b2.execute(method,Emailid,password);

            }
        });

    signup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(LoginActivity.this,SignupActivity.class));
        }
    });
    }
 }


