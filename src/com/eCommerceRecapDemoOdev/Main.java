package com.eCommerceRecapDemoOdev;

import com.eCommerceRecapDemoOdev.business.abstracts.CustomerService;
import com.eCommerceRecapDemoOdev.business.concretes.CustomerCheckManager;
import com.eCommerceRecapDemoOdev.business.concretes.CustomerManager;
import com.eCommerceRecapDemoOdev.business.concretes.CustomerValidManager;
import com.eCommerceRecapDemoOdev.business.concretes.CustomerVerifyManager;
import com.eCommerceRecapDemoOdev.core.concretes.JLoggerManagerAdapter;
import com.eCommerceRecapDemoOdev.dataAccess.abstracts.CustomerDao;
import com.eCommerceRecapDemoOdev.dataAccess.concretes.HibernateCustomerDao;
import com.eCommerceRecapDemoOdev.entities.concretes.Customer;
import com.eCommerceRecapDemoOdev.thirdPartyLogin.AuthService;
import com.eCommerceRecapDemoOdev.thirdPartyLogin.GoogleAuthManager;

public class Main {

    public static void main(String[] args) {
        Customer ulas = new Customer(1, "Ulaş", "Müezzinoğlu", "martulas5252@gmail.com", "123456");
        Customer enginFalse = new Customer(2, "Engin", "Demiroğ", "martulas5252@gmail.com", "1234567");
        Customer engin = new Customer(3, "Engin", "Demiroğ", "engin@gmail.com", "1234567");

        AuthService authService = new GoogleAuthManager();

        CustomerDao customerDao = new HibernateCustomerDao();
        CustomerService customerService = new CustomerManager
                (customerDao, new CustomerCheckManager(), new CustomerValidManager(customerDao), new JLoggerManagerAdapter(), new CustomerVerifyManager());
        customerService.register(ulas);
        customerService.register(enginFalse);
        customerService.register(engin);

        customerService.login("martulas5252@gmail.com", "123456");
        customerService.login("engin@gmail.com", "1234567");


        authService.loginWithGoogle();

    }
}
