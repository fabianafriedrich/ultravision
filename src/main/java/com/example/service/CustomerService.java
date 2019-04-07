package com.example.service;

import com.example.DAO.CustomerDAO;
import com.example.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/*Controller is going to call for  Service and Service is going to call DAO*/

@Service
public class CustomerService {


    /*Dependence Injection*/
    @Autowired
    private CustomerDAO customerDAO;

    public void save(Customer customer){
        customer.setIdCustomer(null);
        customerDAO.save(customer);
    }

    public Customer findBy(Long id){
        Customer c = customerDAO.findById(id).orElse(null);
        return c;
    }

    public void updateCustomer(Customer customer){
        customerDAO.save(customer);
    }



}
