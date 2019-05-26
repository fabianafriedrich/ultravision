package com.example.service;
/*Controller is going to call for  Service and Service is going to call DAO*/

import com.example.DAO.RentDAO;
import com.example.model.Customer;
import com.example.model.Music;
import com.example.model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {

    /*Dependence Injection*/
    @Autowired
    private RentDAO rentDAO;

    public void save(Rent rent){
        rentDAO.save(rent);
    }

    public List<Rent> find(Customer customer){
        List<Rent> rentList = rentDAO.find(customer);
        return rentList;
    }
    public List<Rent> findTitle(String title){
        List<Rent> rentList = rentDAO.findTitle(title);
        return rentList;
    }
    public List<Rent> findBy(String title, Customer customer){
        List<Rent> rentList = rentDAO.findBy(title, customer);
        return rentList;
    }

    public void delete(Rent rent){
        rentDAO.delete(rent);
    }
    public void update(Rent rent){
        rentDAO.save(rent);
    }
}
