package com.example.service;

import com.example.DAO.CustomerDAO;
import com.example.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*Controller is going to call for  Service and Service is going to call DAO*/

@Service
public class CustomerService {


    /*Dependence Injection*/
    @Autowired
    private CustomerDAO customerDAO;

    public void save(Customer customer){
        customerDAO.save(customer);
    }

    public List<Customer> findByName(String name){
        List<Customer> list = customerDAO.findByName(name);
        return list;
    }

//    public Customer findAll(List<Customer> name){
//        Customer c = customerDAO.findAll(name);
//        return c;
//    }

    public void delete(Customer customer){
        customerDAO.delete(customer);
    }
    public void updateCustomer(Customer customer){
        customerDAO.save(customer);
    }





}
