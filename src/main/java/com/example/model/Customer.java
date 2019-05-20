package com.example.model;

import com.example.enums.CustomerEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*Crieting class customer and Table customer in database*/
/*implement the Serializable interface when you need to store a copy of the object,
 send them to another process which runs on the same system or over the network.
 It makes storing and sending objects easy. It has nothing to do with security.*/
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    /*@Id auto increment in database*/
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idCustomer;
    private String customerName;
    private Integer cardNo;
    private CustomerEnum subscriptionPlan;
    private Integer points;

    /*Relation between tables/classes
     * The relation between customer and rent is mapped by customer
     * Array List for the rents
     */
    @OneToMany(mappedBy = "customer")
    private List<Rent> rentList;


    /*Default constructor*/
    public Customer(){
        rentList = new ArrayList<Rent>();
    }

/*Parametrized Constructor iniciating variables*/
    public Customer(Long idCustomer, String customerName, Integer cardNo, CustomerEnum subscriptionPlan, Integer points) {
        this.idCustomer = idCustomer;
        this.customerName = customerName;
        this.cardNo = cardNo;
        this.subscriptionPlan = subscriptionPlan;
        this.points = points;
    }

    /*Getter and setters*/
    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getCardNo() {
        return cardNo;
    }

    public void setCardNo(Integer cardNo) {
        this.cardNo = cardNo;
    }

    public CustomerEnum getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(CustomerEnum subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getSubscriptionPlanDescription() {
        if(this.getSubscriptionPlan()!= null) {
            return this.getSubscriptionPlan().getDescription();
        }
        return "";
    }
}




