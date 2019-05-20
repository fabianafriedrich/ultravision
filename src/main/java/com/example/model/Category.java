package com.example.model;


import com.example.enums.MediaEnum;

import javax.persistence.*;

@MappedSuperclass
public abstract class Category {

    private String title;
    private MediaEnum media;
    private String yearOfRelease;



    /*Default constructor*/
    public Category(){
        super();

    }

    /*Parametrized Constructor iniciating variables*/

    public Category(String title, MediaEnum media, String yearOfRelease) {
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

    public MediaEnum getMedia() {
        return media;
    }

    public void setMedia(MediaEnum media) {
        this.media = media;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }


}
