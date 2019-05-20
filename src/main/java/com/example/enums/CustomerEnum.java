package com.example.enums;

import java.util.Arrays;
import java.util.List;

/*Enum Customer types*/
public enum CustomerEnum {

    ML(1, "MUSIC LOVERS"),
    VL(2,"VIDEO_LOVERS"),
    TL(3,"TV_LOVERS"),
    PR(4,"PREMIUM");

    private int i;
    private String description;

    /*Parametrized Constructor*/
    CustomerEnum( int in ,String s) {
        i = i;
        description = s;
    }

    /*Getter and Setters*/

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return this.description;
    }


}
