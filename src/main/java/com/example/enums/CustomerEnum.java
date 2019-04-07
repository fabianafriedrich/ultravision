package com.example.enums;

/*Enum Customer types*/
public enum CustomerEnum {

    ML(1,"MUSIC LOVERS"),
    VL(2,"VIDEO_LOVERS"),
    TL(3,"TV_LOVERS"),
    PR(4,"PREMIUM");

    private int id;
    private String description;

    /*Parametrized Constructor*/
    CustomerEnum(int i, String s) {
        id = i;
        description = s;
    }

    /*Getter and Setters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
