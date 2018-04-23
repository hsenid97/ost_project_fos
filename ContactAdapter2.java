package com.example.lenovo.basic_mysql;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter2 extends ArrayAdapter{
    List list=new ArrayList();
    public ContactAdapter2( Context context, int resource) {
        super(context, resource);
    }


    public void add( Contacts2 object) {
        super.add(object);
        list.add(object);
    }


    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public View getView(int position,  View convertView,  ViewGroup parent) {
        View row;
        row=convertView;
        ContactHolder ch;
        if(row==null)
        {
            LayoutInflater lf=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=lf.inflate(R.layout.row_layout2,parent,false);
            ch=new ContactHolder();
            ch.tx_item=row.findViewById(R.id.tx_item);
            ch.tx_cost=row.findViewById(R.id.tx_cost);
            ch.tx_shop=row.findViewById(R.id.tx_shop);
            // ch.tx_qty=row.findViewById(R.id.tx_qty);
            row.setTag(ch);
        }
        else
        {
            ch=(ContactHolder)row.getTag();
        }
        Contacts2 ct=(Contacts2) getItem(position);
        ch.tx_item.setText(ct.getItem_name());
        ch.tx_cost.setText(ct.getItem_cost());
        ch.tx_shop.setText(ct.getShop());
        return row;
    }
    static class ContactHolder
    {
        TextView tx_item,tx_cost,tx_shop;

    }
}















