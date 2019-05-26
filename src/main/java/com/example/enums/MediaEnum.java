package com.example.enums;

public enum MediaEnum {
    DVD(1,"DVD"),
    BluRay(2,"Blu-Ray"),
    CD(3, "CD");

    private int i;
    private String media;

    /*Parametrized Constructor*/
    MediaEnum( int i, String m)
    {
        this.i = i;
        this.media = m;
    }

    /*Getter and Setters*/

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return this.media;
    }
}
