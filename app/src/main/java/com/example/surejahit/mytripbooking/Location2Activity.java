package com.example.surejahit.mytripbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Location2Activity extends AppCompatActivity {

    LinearLayout linearLayout;
    EditText edt;
    Button btn,okay;
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location2);


        edt = findViewById(R.id.noPerson);
        okay = findViewById(R.id.ok);
        btn = (Button)findViewById(R.id.confbtn);
         textview = findViewById(R.id.txtshow);


        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str = edt.getText().toString();
                int a = Integer.parseInt(str);
        textview.setText("You have to pay = "+a*500000);

               LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearid);      //find the linear layout
                linearLayout.removeAllViews();


                for (int i = 1; i <=a; i++)
                {
                    /*TextView tv = new TextView(Location2Activity.this);
                    tv.setText("Dynamic TextView" + i);
                    tv.setId(i);
                    linearLayout.addView(tv);
                     */

                    EditText ed = new EditText(Location2Activity.this);
                    ed.setId(i);
                    ed.setHint("name : "+i);
                    linearLayout.addView(ed);

                    EditText ed1 = new EditText(Location2Activity.this);
                    ed1.setId(i+1);
                    ed1.setHint("Aadhar no : "+i);
                    linearLayout.addView(ed1);

                }

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Location2Activity.this,ConformActivity.class);
                startActivity(i1);
            }
        });


    }
}
