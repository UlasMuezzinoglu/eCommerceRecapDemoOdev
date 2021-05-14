package com.eCommerceRecapDemoOdev.dataAccess.abstracts;

import com.eCommerceRecapDemoOdev.entities.concretes.Customer;

import java.util.List;

public interface CustomerDao {
    void add(Customer customer);
    void update(Customer customer);
    void delete(Customer customer);

    Customer get(int id);
    List<Customer> getAll();

}
