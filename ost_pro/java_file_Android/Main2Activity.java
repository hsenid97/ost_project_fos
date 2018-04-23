package com.example.lenovo.basic_mysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i =getIntent();

    }
    public void order_call(View view)
    {
        Intent i=new Intent(this,Main4Activity.class);
        i.putExtra("shop","orders");
        startActivity(i);
    }
    public void accepted_order(View view)
    {
        Intent i=new Intent(this,Main4Activity.class);
        i.putExtra("shop","accept");
        startActivity(i);
    }
    public void logout_func(View view)
    {

        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void clicked_function(View view)
    {
        String table_name="";
            switch(view.getId())
            {
                case R.id.hotel1:table_name="canteen" ;break;
                case R.id.hotel2:table_name="stores" ;break;
                case R.id.hotel3:table_name="fastfood" ;break;
                case R.id.hotel4:table_name="juices" ;break;
            }

            Intent temp=new Intent(Main2Activity.this,Main3Activity.class);
            temp.putExtra("table_name", table_name);
            startActivity(temp);

    }
    /*
    public void onBackPressed() {

        return;
    }*/

}
