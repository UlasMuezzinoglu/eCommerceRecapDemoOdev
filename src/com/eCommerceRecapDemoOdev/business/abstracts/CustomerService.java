package com.eCommerceRecapDemoOdev.business.abstracts;

import com.eCommerceRecapDemoOdev.entities.concretes.Customer;

public interface CustomerService {
    void register(Customer customer);
    void login(String mail, String password);
}
