package com.example.lenovo.basic_mysql;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Main3Activity extends AppCompatActivity {

    String message;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent i =getIntent();
         message = i.getStringExtra("table_name");
        /* tv=(TextView)findViewById(R.id.textView);
        tv.setText(message);
        */

        String type = "menu1";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type);

    }
    public void parseText(String s)
    {
         if(s==null)
         {
              Toast.makeText(getApplicationContext(), "first get json", Toast.LENGTH_LONG).show();
         }
         else
         {
             Intent i=new Intent(this,DisplayListView.class);
             i.putExtra("shop",message);
             i.putExtra("json_data",s);
             startActivity(i);
         }
    }
    public class BackgroundWorker extends AsyncTask<String,Void,String> {
        Context context;
      //  AlertDialog alertDialog;
        String result="";
        BackgroundWorker (Context ctx) {
            context = ctx;
        }
        @Override
        protected String doInBackground(String... params) {
           // String type = params[0];
            //String login_url = "http://192.168.0.102/menu1.php";
            String login_url = "http://10.0.64.110/menu1.php";
            //if(type.equals("menu1")) {
                try {
                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("message","UTF-8")+"="+URLEncoder.encode(message,"UTF-8");
                           // +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));//,"iso-8859-1"));
                    StringBuilder sb=new StringBuilder();
                    String line="";
                    while((line = bufferedReader.readLine())!= null) {
                        sb.append(line+'\n');
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return sb.toString().trim();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            //}
            return null;
        }

        @Override
        protected void onPreExecute() {
        /*    alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Login Status");
        */
        }

        @Override
        protected void onPostExecute(String rresult) {

         //   tv.setText(rresult);
            parseText(rresult);
            }





        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
   /* public void onBackPressed() {

        return;
    }*/
}
