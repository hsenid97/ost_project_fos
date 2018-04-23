package com.example.lenovo.basic_mysql;

public class Contacts2 {
    private  String item_name,item_cost,shop;

    public Contacts2(String item_name, String item_cost, String shop)
    {
        this.setItem_name(item_name);
        this.setItem_cost(item_cost);
        this.setShop(shop);//ty(qty);
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String qty) {
        this.shop = qty;
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