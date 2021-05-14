package com.eCommerceRecapDemoOdev.business.concretes;

import com.eCommerceRecapDemoOdev.business.abstracts.CustomerCheckService;
import com.eCommerceRecapDemoOdev.business.abstracts.CustomerService;
import com.eCommerceRecapDemoOdev.business.abstracts.CustomerValidManagerService;
import com.eCommerceRecapDemoOdev.core.abstracts.LoggerService;
import com.eCommerceRecapDemoOdev.dataAccess.abstracts.CustomerDao;
import com.eCommerceRecapDemoOdev.entities.concretes.Customer;

public class CustomerManager implements CustomerService {

    private CustomerDao customerDao;
    private CustomerCheckService customerCheckService;
    private CustomerValidManagerService customerValidManagerService;
    private LoggerService loggerService;
    private CustomerVerifyManager customerVerifyManager;

    public CustomerManager(CustomerDao customerDao,CustomerCheckService customerCheckService,
                           CustomerValidManagerService customerValidManagerService,
                           LoggerService loggerService,
                           CustomerVerifyManager customerVerifyManager){

        this.customerDao = customerDao;
        this.customerCheckService = customerCheckService;
        this.customerValidManagerService = customerValidManagerService;
        this.loggerService = loggerService;
        this.customerVerifyManager = customerVerifyManager;
    }



    @Override
    public void register(Customer customer) {


        if (customerCheckService.mailController(customer.getMail()) && customerCheckService.passwordController(customer.getPassword()) && customerCheckService.nameController(customer.getFirstName(),customer.getLastName()) && customerValidManagerService.isMailExist(customer.getMail()))
        {
            customerDao.add(customer);
            loggerService.log(customer.getMail());
            customerVerifyManager.sendVerifyMail(customer.getMail());


        }

    }

    @Override
    public void login(String mail, String password) {
        boolean flag = false;
        for (Customer customer : customerDao.getAll()){
            if (mail.equals(customer.getMail()) && password.equals(customer.getPassword())){
                System.out.println(mail+" : Kullanıcısı Giriş Yaptı");
                flag = true;
                return;
            }

        }
        if(!flag){
                System.out.println("Kullanıcı Bulunamadı.");
        }





    }
}
