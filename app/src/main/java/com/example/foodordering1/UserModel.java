package com.example.foodordering1;

import java.io.Serializable;

public class UserModel implements Serializable {
    private String itemname;
    public UserModel(String itemname){
        this.itemname = itemname;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }
}
