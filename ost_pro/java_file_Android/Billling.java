package com.example.lenovo.basic_mysql;

import java.io.Serializable;

public class Billling implements Serializable {
        /*String item_name[]=new String[20];
            String item_cost[]=new String[20];
        int quantity[]=new int[20];*/
        String item_name,item_cost,shop;

        int c=0;

      /*  public Billling()
        {
            counter=0;
        }*/
        public void addItem(String s1,String s2,String s3)//,int val)
        {
            item_name=s1;
            item_cost=s2;
            shop=s3;
            //quantity[c]=val;
            c=c+1;
        }
        public String getItem()
        {
            return  item_name+"  "+item_cost;
        }
}/*    public void evaluate(View view)
    {
        Intent intent = new Intent(DisplayListView.this,sendmessage.class);

        String message="";
        Billling b =new Billling();
        for(int i=0;i<size_of_json;i++)
        {
            Contacts cc=(Contacts) ca.getItem(i);
            String s=cc.getQty();
            if(s!=null)
            {
                message = message +"abc  "+cc.getItem_name()+"  "+cc.getItem_cost();
                b.addItem(cc.getItem_name(),cc.getItem_cost(),Integer.parseInt(cc.getQty()));
            }
        }
        intent.putExtra("bills", b);
        startActivity(intent);

    }
*/