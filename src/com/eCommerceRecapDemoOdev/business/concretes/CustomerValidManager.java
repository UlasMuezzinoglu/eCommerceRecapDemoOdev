package com.eCommerceRecapDemoOdev.business.concretes;

import com.eCommerceRecapDemoOdev.business.abstracts.CustomerValidManagerService;
import com.eCommerceRecapDemoOdev.dataAccess.abstracts.CustomerDao;
import com.eCommerceRecapDemoOdev.entities.concretes.Customer;

public class CustomerValidManager implements CustomerValidManagerService {

    CustomerDao customerDao;

    public CustomerValidManager(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @Override
    public boolean isMailExist(String mail) {
        for (Customer customer : customerDao.getAll()) {
            if (mail.equals(customer.getMail())) {
                System.out.println("Bu Mail Adresi Kullanılmış. Lütfen Başka Kullanın");
                return false;
            }

        }
        return true;
    }
}

