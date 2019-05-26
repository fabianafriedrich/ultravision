package com.example.mvc;

import com.example.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MembershipCard {

    @Autowired
    private View view;

    private int points ;
    private boolean freeRentAllowed;

    public MembershipCard(){
        }
    public void addPoints(Customer points){
        points.getPoints();
        this.points += points.getPoints();
        setRentAllowed();
    }

    public boolean availFreeRent(){
        if(this.isfreeRentAllowed()){
            this.points -= 100;
            setRentAllowed();
            return true;
        } else {
            return false;
        }
    }

    private void setRentAllowed(){
        if (this.points >= 100){
            this.freeRentAllowed = true;
        } else {
            this.freeRentAllowed = false;
        }
    }

    public int getPoints() {
        return  points;
    }

    public boolean isfreeRentAllowed(){
        return freeRentAllowed;

    }

}
