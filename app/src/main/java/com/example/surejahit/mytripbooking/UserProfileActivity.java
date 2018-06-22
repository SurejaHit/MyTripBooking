package com.example.surejahit.mytripbooking;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.http.RequestQueue;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class UserProfileActivity extends AppCompatActivity {

    com.android.volley.RequestQueue rq;
    TextView txt1,txt2,txt3,txt4,txt5;
    String str1,str2,str3,str4,str5;
    Button btn1,btn2;
    String show_url = "http://10.0.2.2/webapp/profile.php";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        txt1 = findViewById(R.id.txtemail);
        txt2 = findViewById(R.id.txttrip);
        txt3 = findViewById(R.id.txtno_person);
        txt4 = findViewById(R.id.txtp_name);
        txt5 = findViewById(R.id.txtaadhar_no);

        rq = Volley.newRequestQueue(UserProfileActivity.this);

    }



    public void Logoutmethod(View view) {

        Userlog l = new Userlog(this);
        l.removeuser();
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void Jsonmethod()
    {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, show_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response){
            try
            {
                    str1 = response.getString("email1");
                    str2 = response.getString("trip");
                    str3 = response.getString("no_person");
                    str4 = response.getString("p_name");
                    str5 = response.getString("aadhar_no");

                    txt1.setText(str1);
                txt2.setText(str2);
                txt3.setText(str3);
                txt4.setText(str4);
                txt5.setText(str5);


            }catch(JSONException e)
              {
                e.printStackTrace();
              }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        rq.add(jsonObjectRequest);

    }

}