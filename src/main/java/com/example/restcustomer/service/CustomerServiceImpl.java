package com.example.restcustomer.service;

import com.example.restcustomer.dao.CustomerRepository;
import com.example.restcustomer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    @Transactional
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
    @Override
    @Transactional
    public void saveCustomer(Customer customer){
         customerRepository.save(customer);
    }
    @Override
    @Transactional
    public Customer getCustomer(int cusId){
        return customerRepository.getById(cusId);
    }
    @Override
    @Transactional
    public void deleteCustomer(int cusId){
        customerRepository.deleteById(cusId);
    }

}