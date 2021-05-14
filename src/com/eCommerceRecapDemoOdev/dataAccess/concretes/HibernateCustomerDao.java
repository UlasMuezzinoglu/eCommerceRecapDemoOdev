package com.eCommerceRecapDemoOdev.dataAccess.concretes;

import com.eCommerceRecapDemoOdev.business.abstracts.CustomerService;
import com.eCommerceRecapDemoOdev.dataAccess.abstracts.CustomerDao;
import com.eCommerceRecapDemoOdev.entities.concretes.Customer;

import java.util.ArrayList;
import java.util.List;

public class HibernateCustomerDao implements CustomerDao {
    List<Customer> customers = new ArrayList<Customer>();
    @Override
    public void add(Customer customer) {
        System.out.println("Hibernate ile eklendi: "+customer.getFirstName()+" "+customer.getLastName());
        customers.add(customer);
    }

    @Override
    public void update(Customer customer) {
        System.out.println("Hibernate ile Güncellendi: "+customer.getFirstName()+" "+customer.getLastName());

    }

    @Override
    public void delete(Customer customer) {
        System.out.println("Hibernate ile Silindi: "+customer.getFirstName()+" "+customer.getLastName());

    }

    @Override
    public Customer get(int id) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }
}
