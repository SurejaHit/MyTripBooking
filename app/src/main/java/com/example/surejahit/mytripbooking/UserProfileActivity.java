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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserProfileActivity extends AppCompatActivity {

    com.android.volley.RequestQueue rq;
    EditText txt3,txt4,txt5;
    TextView username,txt1,txt2;
    String str1,str2,str3,str4,str5;
    Button btn1,btn2;
    String show_url = "http://10.0.2.2/webapp/profile.php";
    String update_url = "http://10.0.2.2/webapp/update.php";
    String delete_url = "http://10.0.2.2/webapp/delete.php";
    private StringRequest request1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        rq = Volley.newRequestQueue(UserProfileActivity.this);

        username = findViewById(R.id.Unametxt);
        String str = getIntent().getStringExtra("name");
        username.setText(str);

        txt1 = findViewById(R.id.txtemail);
        txt2 = findViewById(R.id.txttrip);
        txt3 = findViewById(R.id.txtno_person);
        txt4 = findViewById(R.id.txtp_name);
        txt5 = findViewById(R.id.txtaadhar_no);

    }



    public void Logoutmethod(View view) {

        Userlog l = new Userlog(this);
        l.removeuser();
        startActivity(new Intent(this, LoginActivity.class));
    }


    public void Updatemethod(View view)
    {
        request1 = new StringRequest(Request.Method.POST, update_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.names().get(1).equals("Data updated successfully!!!")){
                        Toast.makeText(getApplicationContext(),"Successfully updated",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Updation failed",Toast.LENGTH_LONG).show();

                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap = new HashMap<String,String>();
                //hashMap.put("data1",txt1.getText().toString());
                //hashMap.put("data2",txt2.getText().toString());
                hashMap.put("data3",txt3.getText().toString());
                hashMap.put("data4",txt4.getText().toString());
                hashMap.put("data5",txt5.getText().toString());
                return hashMap;
            }
        };
        rq.add(request1);


    }

        public void Deletemethod(View view)
        {
            request1 = new StringRequest(Request.Method.POST, delete_url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        if(jsonObject.names().get(1).equals("Data deleted successfully!!!")){
                            Toast.makeText(getApplicationContext(),"Successfully deleted",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Deletion failed",Toast.LENGTH_LONG).show();

                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String,String> hashMap = new HashMap<String,String>();
                    hashMap.put("data1",txt1.getText().toString());
                    return hashMap;
                }
            };
            rq.add(request1);


        }


    public void Jsonmethod(View view)
    {

        //This method is used for send data to php file
        /*request1 = new StringRequest(Request.Method.POST, show_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            try {
                JSONObject jsonObject = new JSONObject(response);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap = new HashMap<String,String>();
                hashMap.put("email1",username.getText().toString());
                return hashMap;
            }
        };
        rq.add(request1);


    */


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,show_url, null,new Response.Listener<JSONObject>() {

        @Override
            public void onResponse(JSONObject response){
                try{
                    JSONArray students = response.getJSONArray("students");
                    for (int i = 0; i < students.length(); i++) {
                        JSONObject student = students.getJSONObject(i);

                        str1 = student.getString("email1");
                        str2 = student.getString("trip");
                        str3 = student.getString("no_person");
                        str4 = student.getString("p_name");
                        str5 = student.getString("aadhar_no");

                        txt1.setText(str1);
                        txt2.setText(str2);
                        txt3.setText(str3);
                        txt4.setText(str4);
                        txt5.setText(str5);

                        //String firstname = student.getString("email1");
                        //String lastname = student.getString("trip");
                        //String age = student.getString("no_person");

                        // txt1.append(firstname + " " + lastname + " " + age + " \n");
                    }
                    // txt1.append("===\n");

                } catch (JSONException e) {
                    e.printStackTrace();}
               /* try
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
                }*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.append(error.getMessage());
            }
        });
        rq.add(jsonObjectRequest);

    }


}