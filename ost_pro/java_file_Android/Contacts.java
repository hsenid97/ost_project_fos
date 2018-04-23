package com.example.lenovo.basic_mysql;

public class Contacts {
    private  String item_name,item_cost,item_qty;

    public Contacts(String item_name, String item_cost, String qty)
    {
        this.setItem_name(item_name);
        this.setItem_cost(item_cost);
        this.setQty(item_qty);//ty(qty);
    }

    public String getQty() {
        return item_qty;
    }

    public void setQty(String qty) {
        this.item_qty = qty;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_cost() {
        return item_cost;
    }

    public void setItem_cost(String item_cost) {
        this.item_cost = item_cost;
    }



}