package com.example.surejahit.mytripbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        String str1 = pass1.getText().toString();
        String str2 = pass2.getText().toString();
        String str3 = uname.getText().toString();
        String str4 = eml.getText().toString();


        if(str1.equals("") || str2.equals("") || str3.equals("") || str4.equals("")){
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        }
        else if(!str1.equals(str2)) {
            Toast.makeText(this, "Password Not matching", Toast.LENGTH_SHORT).show();
        }
        else{
        username =uname.getText().toString();
        emailid=eml.getText().toString();
        password=pass1.getText().toString();
       String method = "Register";
        BackgroundTask b1 = new BackgroundTask(this);
       b1.execute(method,username,emailid,password);
       startActivity(new Intent(this,HomeActivity.class));
       finish();
    }
    }

}
