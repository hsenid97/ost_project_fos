package com.example.lenovo.basic_mysql;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

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
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class DisplayListView2 extends AppCompatActivity {
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ContactAdapter2 ca;
    ListView lv;
    int size_of_json;
    String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_view2);
        ca=new ContactAdapter2(this,R.layout.row_layout2);
        lv=(ListView)findViewById(R.id.listview);
        lv.setAdapter(ca);
        json_string=getIntent().getExtras().getString("json_data");
        msg=getIntent().getExtras().getString("shop");
        try {
            jsonObject=new JSONObject(json_string);
            jsonArray=jsonObject.getJSONArray("server_response");
            int count=0;
            String item_name,item_cost,shop_name;
            while(true)//count<=jsonObject.length())
            {

                try {
                    JSONObject jo=jsonArray.getJSONObject(count);
                    item_name = jo.getString("item_name");
                    item_cost = jo.getString("item_cost");
                    shop_name=jo.getString("shop");
                    size_of_json++;
                    if(item_name==null || item_cost==null)break;

                }
                catch (Exception e)
                {
                    break;
                }
                Contacts2 c=new Contacts2(item_name,item_cost,shop_name);
                ca.add(c);
                count++;
            }

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position,
                                        long id) {

                    Billling b =new Billling();
                    Contacts2 cc=(Contacts2) ca.getItem(position);
                    //String message = "abc  "+cc.getItem_name()+"  "+cc.getItem_cost();
                    // EditText et=(EditText)findViewById(R.id.tx_qty);
                    //    String s=et.getText().toString();
                    b.addItem(cc.getItem_name(),cc.getItem_cost(),msg);//,Integer.parseInt(s));
                    //cc.setQty(s);
                    Intent intent = new Intent(DisplayListView2.this,Main5Activity.class);

                    intent.putExtra("bills",b);
                    startActivity(intent);

                }
            });
        } catch (JSONException e) {

        }
    }
/*    public void evaluate(View view1)
    {
        Background b=new Background(this);
        b.execute();

    }

    public class Background extends AsyncTask<String,Void,String> {
        Context context;

        Background (Context ctx) {
            context = ctx;
        }
        @Override
        protected String doInBackground(String... params) {

            String message="";

            for(int i=0;i<size_of_json;i++)
            {
                View view=lv.getChildAt(i);
                EditText editText=view.findViewById(R.id.tx_qty);
                String string=editText.getText().toString();
                Contacts cc=(Contacts) ca.getItem(i);
                String s=string;
                if(!s.equals(""))
                {
                    message = message +"abc  "+cc.getItem_name()+"  "+cc.getItem_cost();
                    b.addItem(cc.getItem_name(),cc.getItem_cost(),Integer.parseInt(s));
                }
            }
            return message;
                   }

        @Override
        protected void onPreExecute() {
           }

        @Override
        protected void onPostExecute(String result) {
                   }
    }
*/

    //@Override
    public void onBackPressed() {
        Intent i =new Intent(this,Main2Activity.class);
        startActivity(i);
    }
}
