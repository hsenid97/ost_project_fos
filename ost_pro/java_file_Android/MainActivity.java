package com.example.lenovo.basic_mysql;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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


public class MainActivity extends AppCompatActivity {
     TextView tv;
     ImageView iv;

    EditText UsernameEt, PasswordEt;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Intent i=getIntent();
            UsernameEt = (EditText)findViewById(R.id.etUserName);
            PasswordEt = (EditText)findViewById(R.id.etPassword);
        }
        public int function_check(String s1,String s2)
        {
                if(s1.length()==12 && s2.length()>=6)
                {
                    if(s1.charAt(0)=='3' && s1.charAt(1)=='1')
                    {
                        if(s1.charAt(5)=='6' && s1.charAt(6)=='5'&& s1.charAt(4)=='2')
                        {
                            return 1;
                        }
                        else
                            return 0;
                    }
                    else
                        return 0;
                }

                return 0;
        }

    public void OnLogin(View view) {
            String username = UsernameEt.getText().toString();
            String password = PasswordEt.getText().toString();
            if(function_check(username,password)==1) {


                String type = "login";
                BackgroundWorker backgroundWorker = new BackgroundWorker(this);
                backgroundWorker.execute(type, username, password);
            }
            else
            {
                UsernameEt.setText("failed");
                PasswordEt.setText("");
            }
         }
    public class BackgroundWorker extends AsyncTask<String,Void,String> {
        Context context;
        AlertDialog alertDialog;
        String result="";
        String u,p;
        BackgroundWorker (Context ctx) {
            context = ctx;
        }
        @Override
        protected String doInBackground(String... params) {
            String type = params[0];
           // String login_url = "http://192.168.0.102/login.php";
            String login_url = "http://10.0.64.110/login.php";
            if(type.equals("login")) {
                try {
                    String user_name = params[1];
                    String password = params[2];
                   u=user_name;
                   p=password;
                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"
                            +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                    String line="";
                    while((line = bufferedReader.readLine())!= null) {
                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Login Status");
        }

        @Override
        protected void onPostExecute(String result) {
            UsernameEt.setText(result);
            if(result.equals("success")){
                personal_info pi=new personal_info(u,p);
            Intent i = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(i);

            }


        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
    public void onBackPressed() {

        return;
    }
    }/*<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <EditText
        android:id="@+id/etUserName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_marginTop="47dp"
        android:ems="10"
        android:inputType="textPersonName" />

    <EditText
        android:id="@+id/etPassword"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true"
        android:layout_below="@+id/etUserName"
        android:ems="10"
        android:inputType="textPassword" />

    <Button
        android:id="@+id/btnLogin"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true"
        android:layout_below="@+id/etPassword"
        android:layout_marginLeft="48dp"
        android:layout_marginStart="48dp"
        android:layout_marginTop="50dp"
        android:onClick="OnLogin"
        android:text="Login" />


</LinearLayout>
*/