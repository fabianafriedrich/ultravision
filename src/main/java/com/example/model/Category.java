package com.example.model;


import javax.persistence.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
public abstract class Category {

    private String title;
    private String media;
    private Year yearOfRelease;



    /*Default constructor*/
    public Category(){
        super();

    }

    /*Parametrized Constructor iniciating variables*/

    public Category(String title, String media, Year yearOfRelease) {
        this.title = title;
        this.media = media;
        this.yearOfRelease = yearOfRelease;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public Year getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Year yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }


}
