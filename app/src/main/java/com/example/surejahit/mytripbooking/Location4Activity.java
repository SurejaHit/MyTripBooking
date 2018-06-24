package com.example.surejahit.mytripbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Location4Activity extends AppCompatActivity {

    LinearLayout linearLayout;
    EditText edt,ed[],ed1[];
    Button conformbtn,okaybtn;
    TextView textview;
   EditText email00;
    com.android.volley.RequestQueue rq;
    String insert_url = "http://10.0.2.2/webapp/trip.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location4);
        rq = Volley.newRequestQueue(Location4Activity.this);
        email00 = findViewById(R.id.edtem);
        edt = findViewById(R.id.noPerson);
        okaybtn = findViewById(R.id.ok);
        conformbtn = (Button) findViewById(R.id.confbtn);
       textview = findViewById(R.id.txtshow);

        rq = Volley.newRequestQueue(getApplicationContext());
        okaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TextView date1 = findViewById(R.id.date1);

                SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
                Date todayDate = new Date();
                String thisDate = currentDate.format(todayDate);

                if (thisDate.compareTo(date1.getText().toString()) < 0) {

                    String str = edt.getText().toString();
                    int a = Integer.parseInt(str);
                    textview.setText("You have to pay = " + a * 100000);

                    LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearid);      //find the linear layout
                    linearLayout.removeAllViews();

                    ed = new EditText[a];
                    ed1 = new EditText[a];
                    for (int i = 0; i < a; i++) {

                        ed[i] = new EditText(Location4Activity.this);
                        //ed[i].setId(i);
                        ed[i].setHint("name : " + i);
                        linearLayout.addView(ed[i]);

                        ed1[i] = new EditText(Location4Activity.this);
                        //ed1[i].setId(i + 1);
                        ed1[i].setHint("Aadhar no : " + i);
                        linearLayout.addView(ed1[i]);


                    }


                }else{
                    Toast.makeText(getApplicationContext(), "Registration is closed", Toast.LENGTH_LONG).show();
                }
            }
        });


        conformbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                StringRequest request1;
                edt = findViewById(R.id.noPerson);
                String str = edt.getText().toString();
                final int no_person = Integer.parseInt(str);

                String arr1[] = new String[no_person];
                String arr2[] = new String[no_person];
                String names,aadhars;
                for (int i = 0; i < no_person; i++) {
                    arr1[i] = ed[i].getText().toString();
                    arr2[i] = ed1[i].getText().toString();
                }

                names = arr1[0];
                aadhars = arr2[0];

                for(int i=0;i<no_person;i++)
                {
                    names = names + ", "+arr1[i];
                    aadhars = aadhars + ", "+arr2[i];
                }


                final String finalNames = names;
                final String finalAadhars = aadhars;
                request1 = new StringRequest(Request.Method.POST, insert_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.names().get(0).equals("success")) {
                                Toast.makeText(getApplicationContext(), "Successfully inserted", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Insertion failed", Toast.LENGTH_LONG).show();

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> hashMap = new HashMap<String, String>();
                        hashMap.put("data1",email00.getText().toString());
                        hashMap.put("data2","New York");
                        hashMap.put("data3","3");
                        hashMap.put("data4", finalNames);
                        hashMap.put("data5", finalAadhars);
                        return hashMap;
                    }
                };
                rq.add(request1);



                Intent i1 = new Intent(Location4Activity.this, ConformActivity.class);
                startActivity(i1);
            }
        });
    }


    }