package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*Crieting class customer and Table customer in database*/
/*implement the Serializable interface when you need to store a copy of the object,
 send them to another process which runs on the same system or over the network.
 It makes storing and sending objects easy. It has nothing to do with security.*/
@Entity
@Table(name = "rent")
public class Rent implements Serializable{

    /*@Id auto increment in database*/
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idRent;
    private Date dateRented;
    private Date dateReturnedRent;
    private boolean rented;
    @Column(name = "title_name")
    private String titleName;

    /*Relation between tables/classes*/
    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    /*Default constructor*/
    public Rent(){
        super();
    }

    /*Parametrized Constructor iniciating variables*/

    public Rent(Integer idRent, Date dateRented, Date dateReturnedRent, boolean rented, Customer customer,String titleName) {
        this.idRent = idRent;
        this.dateRented = dateRented;
        this.dateReturnedRent = dateReturnedRent;
        this.rented = rented;
        this.customer = customer;
        this.titleName = titleName;
    }

    /*Getter and Setter*/
    public Integer getIdRent() {
        return idRent;
    }

    public void setIdRent(Integer idRent) {
        this.idRent = idRent;
    }

    public Date getDateRented() {
        return dateRented;
    }

    public void setDateRented(Date dateRented) {
        this.dateRented = dateRented;
    }

    public Date getDateReturnedRent() {
        return dateReturnedRent;
    }

    public void setDateReturnedRent(Date dateReturnedRent) {
        this.dateReturnedRent = dateReturnedRent;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}

