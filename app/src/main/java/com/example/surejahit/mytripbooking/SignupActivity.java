package com.example.surejahit.mytripbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {

    EditText uname,eml,pass1,pass2;
    String username,emailid,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        uname = (EditText) findViewById(R.id.name);
        eml = (EditText) findViewById(R.id.Email);
        pass1 = (EditText) findViewById(R.id.psw1);
        pass2 = (EditText) findViewById(R.id.psw2);

    }

    public void userReg(View view)
    {
        username =uname.getText().toString();
        emailid=eml.getText().toString();
        password=pass1.getText().toString();
       String method = "Register";
        BackgroundTask b1 = new BackgroundTask(this);
       b1.execute(method,username,emailid,password);
       startActivity(new Intent(this,MainActivity.class));
       finish();
    }

}
