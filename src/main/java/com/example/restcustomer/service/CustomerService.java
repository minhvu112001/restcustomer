package com.example.restcustomer.service;

import com.example.restcustomer.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

   public void deleteCustomer(int theId);

}
