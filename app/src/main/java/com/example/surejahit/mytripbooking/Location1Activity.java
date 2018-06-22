package com.example.surejahit.mytripbooking;

import android.app.Activity;
import android.content.Intent;
import android.net.http.RequestQueue;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static android.media.CamcorderProfile.get;

public class Location1Activity extends AppCompatActivity {

    LinearLayout linearLayout;
    EditText edt;
    Button btn, okay;
    TextView textview;
    public Date date;
    com.android.volley.RequestQueue mRequestQueue;
    String insert_url = "http://10.0.2.2/webapp/trip.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location1);


        edt = findViewById(R.id.noPerson);
        okay = findViewById(R.id.ok);
        btn = (Button) findViewById(R.id.confbtn);
        textview = findViewById(R.id.txtshow);
        mRequestQueue = Volley.newRequestQueue(getApplicationContext());

        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView date1 = findViewById(R.id.date1);

                SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
                Date todayDate = new Date();
                String thisDate = currentDate.format(todayDate);
                                  /*try {
                   date = new SimpleDateFormat("dd/MM/yyyy").parse(date1.getText().toString());
                   textview.setText((CharSequence) date);
                }catch (Exception e)
                {
                    e.getStackTrace();
                }*/

                if (thisDate.compareTo(date1.getText().toString()) < 0) {
                    String str = edt.getText().toString();
                    int a = Integer.parseInt(str);

                    textview.setText("You have to pay = " + a * 30000);

                    LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearid);      //find the linear layout
                    linearLayout.removeAllViews();

                    String arr1[] = new String[a];
                    String arr2[] = new String[a];
                    for (int i = 1; i <= a; i++) {
                    /*TextView tv = new TextView(Location2Activity.this);
                    tv.setText("Dynamic TextView" + i);
                    tv.setId(i);
                    linearLayout.addView(tv);
                     */

                        EditText ed = new EditText(Location1Activity.this);
                        ed.setId(i);
                        arr1[i] = ed.getText().toString();
                        ed.setHint("name : " + i);
                        linearLayout.addView(ed);

                        EditText ed1 = new EditText(Location1Activity.this);
                        ed1.setId(i + 1);
                        arr1[i] = ed.getText().toString();
                        ed1.setHint("Aadhar no : " + i);
                        linearLayout.addView(ed1);

                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Registration is closed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void tripCall(View view) {
        edt = findViewById(R.id.noPerson);
        String str = edt.getText().toString();
        final int no_person = Integer.parseInt(str);



  /*
        JsonObjectRequest  jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, insert_url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

*/
        final String trip_name = "Manali";
        final String email1 = "Hello";
        final String names = "ABC";
        final String aadhar_nos = "1234567";

      /*  for(int i=0;i<=no_person;i++)
        {
            EditText textE = findViewById(R.id.i);
            names = edt.getText().toString();

            EditText textE1 = findViewById(R.id.(i+1));
            aadhar_nos = edt.getText().toString();

        }*/

        StringRequest request = new StringRequest(Request.Method.POST, insert_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("email1", email1);
                parameters.put("trip", trip_name);
                parameters.put("no_person", String.valueOf(no_person));
                parameters.put("p_name", names);
                parameters.put("aadhar_nos", aadhar_nos);
                return parameters;
            }
        };
        mRequestQueue.add(request);


    }
}







       /*
            String method = "Trip";
            BackgroundTask001 b1 = new BackgroundTask001(this);
            //b1.execute(method,email,trip_name,str,names,aadhar_nos);
            Intent i1 = new Intent(Location1Activity.this,ConformActivity.class);
            startActivity(i1);
        }
    }

*/

