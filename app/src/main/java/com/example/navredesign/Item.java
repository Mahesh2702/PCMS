package com.example.navredesign;

public class Item {

    private String itemNo;
    private String itemValue;

    public Item(String itemNo, String itemValue) {
        this.itemNo = itemNo;
        this.itemValue = itemValue;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }
}
