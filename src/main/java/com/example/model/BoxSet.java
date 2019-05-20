package com.example.model;

import javax.persistence.*;
import javax.rmi.CORBA.Tie;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/*Crieting class BoxSet and Table BoxSet in database*/
/*implement the Serializable interface when you need to store a copy of the object,
 send them to another process which runs on the same system or over the network.
 It makes storing and sending objects easy. It has nothing to do with security.*/
@Entity
@Table(name = "boxSet")
public class BoxSet extends Category implements Serializable{

    /*@Id auto increment in database*/
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idBoxSet;
    private String directorBoxSet;
    private String genreBoxSet;



    /*Default constructor*/
    public BoxSet(){
        super();
    }

    /*Parametrized Constructor iniciating variables*/

    public BoxSet(Long idBoxSet, String directorBoxSet, String genreBoxSet, Category category) {
        this.idBoxSet = idBoxSet;
        this.directorBoxSet = directorBoxSet;
        this.genreBoxSet = genreBoxSet;

    }

    /*Getter and setter*/
    public Long getIdBoxSet() {
        return idBoxSet;
    }

    public void setIdBoxSet(Long idBoxSet) {
        this.idBoxSet = idBoxSet;
    }

    public String getDirectorBoxSet() {
        return directorBoxSet;
    }

    public void setDirectorBoxSet(String directorBoxSet) {
        this.directorBoxSet = directorBoxSet;
    }

    public String getGenreBoxSet() {
        return genreBoxSet;
    }

    public void setGenreBoxSet(String genreBoxSet) {
        this.genreBoxSet = genreBoxSet;
    }

}
