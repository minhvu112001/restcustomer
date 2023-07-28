package com.example.restcustomer.rest;

public class CustomerNotFoundException extends RuntimeException {
    private Integer customerId;

    public CustomerNotFoundException(String employeeId) {
        super("Employee not found with ID : " + employeeId);
        this.customerId = customerId;
    }
}