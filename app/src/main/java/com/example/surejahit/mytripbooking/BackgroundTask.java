package com.example.surejahit.mytripbooking;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import static android.support.v4.content.ContextCompat.startActivity;

public class BackgroundTask extends AsyncTask<String,Void,String> {


    AlertDialog altD;
    Context ctx;


    BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String signup_url = "http://10.0.2.2/webapp/register.php";
        String login_url = "http://10.0.2.2/webapp/login.php";
        String method = params[0];

        if (method.equals("Register")) {
            String name11 = params[1];//This values will go to register.php file
            String email11 = params[2];
            String pass11 = params[3];
            try {
                URL u1 = new URL(signup_url);
                HttpURLConnection http1 = (HttpURLConnection) u1.openConnection();
                http1.setRequestMethod("POST");
                http1.setDoOutput(true);
                OutputStream os1 = http1.getOutputStream();
                BufferedWriter bf1 = new BufferedWriter(new OutputStreamWriter(os1, "utf-8"));

                String data1 = URLEncoder.encode("name11", "utf-8") + "=" + URLEncoder.encode(name11, "utf-8") + "&" +
                        URLEncoder.encode("email11", "utf-8") + "=" + URLEncoder.encode(email11, "utf-8") + "&" +
                        URLEncoder.encode("pass11", "utf-8") + "=" + URLEncoder.encode(pass11, "utf-8");
                bf1.write(data1);
                bf1.flush();
                bf1.close();
                os1.close();

                InputStream is1 = http1.getInputStream();
                is1.close();
                return "Registration successful!!!";
            } catch (MalformedURLException m) {
                m.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (method.equals("Login")) {
            String emailL = params[1]; //This values will go into login.php file
            String passL = params[2];

            try {
                URL u2 = new URL(login_url);
                HttpURLConnection http2 = (HttpURLConnection) u2.openConnection();
                http2.setRequestMethod("POST");
                http2.setDoOutput(true);
                http2.setDoInput(true);
                OutputStream os2 = http2.getOutputStream();


                BufferedWriter bf2 = new BufferedWriter(new OutputStreamWriter(os2, "UTF-8"));


                String data2 = URLEncoder.encode("emailL", "UTF-8") + "=" + URLEncoder.encode(emailL, "UTF-8") + "&" +
                        URLEncoder.encode("passL", "UTF-8") + "=" + URLEncoder.encode(passL, "UTF-8");
                bf2.write(data2);
                bf2.flush();
                bf2.close();
                os2.close();

                InputStream is2 = http2.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is2, "iso-8859-1"));

                String response = "";
                String line = "";

                while ((line = br.readLine()) != null) {
                    response += line;
                }
                br.close();
                is2.close();
                http2.disconnect();


                return response;

            } catch (MalformedURLException i) {
                i.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }

        }

        return null;
    }

    protected void onPreExecute() {
        altD = new AlertDialog.Builder(ctx).create();
        altD.setTitle("Login Information....");
    }


    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    protected void onPostExecute(String result) {
        if (result.equals("Registration successful!!!")) {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        } else {
            altD.setMessage(result);
            altD.show();

        }

    }
}
