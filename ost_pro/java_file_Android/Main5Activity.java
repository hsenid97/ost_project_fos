package com.example.lenovo.basic_mysql;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

public class Main5Activity extends AppCompatActivity {

    TextView t1, t2;
    Billling bill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Intent i = getIntent();
        bill = (Billling) i.getSerializableExtra("bills");


        t1 = (TextView) findViewById(R.id.text1);
        t2 = (TextView) findViewById(R.id.text2);
        t1.setText(bill.item_name);
        t2.setText(bill.item_cost);

    }
    public void order_items(View view)
    {
        BackgroundWorker123 b = new BackgroundWorker123(this);
        b.execute();
    }
    public class BackgroundWorker123 extends AsyncTask<String, Void, String> {
        Context context;
        String result = "";

        BackgroundWorker123(Context ctx) {
            context = ctx;
        }

        @Override
        protected String doInBackground(String... params) {

           // String login_url = "http://192.168.0.102/cancel_orders.php";
            String login_url = "http://10.0.64.110/cancel_orders.php";
            try {
                personal_info pi=new personal_info();
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(pi.username, "UTF-8") + "&"
                        + URLEncoder.encode("item_name", "UTF-8") + "=" + URLEncoder.encode(bill.item_name, "UTF-8")+ "&"
                        + URLEncoder.encode("item_cost", "UTF-8") + "=" + URLEncoder.encode(bill.item_cost, "UTF-8")+ "&"
                        + URLEncoder.encode("shop", "UTF-8") + "=" + URLEncoder.encode(bill.shop, "UTF-8");
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

            return null;
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onPostExecute(String result) {


                Intent i = new Intent(Main5Activity.this, Main2Activity.class);
                startActivity(i);




        }

    }

}
