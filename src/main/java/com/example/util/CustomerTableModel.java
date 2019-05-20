package com.example.util;

import com.example.model.Customer;
import org.apache.catalina.User;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CustomerTableModel extends AbstractTableModel {

    private List<Customer> customers;

    public CustomerTableModel(List<Customer> customers) {
        this.customers = new ArrayList<Customer>(customers);
    }

    @Override
    public int getRowCount() {
        return customers.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = "??";
        Customer customer = customers.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = customer.getIdCustomer();
                break;
            case 1:
                value = customer.getCustomerName();
                break;
            case 2:
                value = customer.getCardNo();
                break;
            case 3:
                value = customer.getPoints();
                break;
            case 4:
                value = customer.getSubscriptionPlan();
                break;
        }

        return value;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
