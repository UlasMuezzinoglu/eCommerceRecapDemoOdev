package com.eCommerceRecapDemoOdev.business.concretes;

import com.eCommerceRecapDemoOdev.business.abstracts.CustomerCheckService;
import com.eCommerceRecapDemoOdev.dataAccess.abstracts.CustomerDao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerCheckManager implements CustomerCheckService {




    @Override
    public boolean passwordController(String password) {
        if(password.length() < 6){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean mailController(String mail) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mail);
        if (matcher.matches()) {
            return true;
        } else {
            System.out.println("Mailiniz geçersiz! Lütfen girdiğiniz e-postayı kontrol ettikten sonra geçerli bir e-posta girin. Mail:" + mail);
            return false;
        }
    }

    @Override
    public boolean nameController(String firstName, String lastName) {
        if(firstName.length() < 2 && lastName.length() < 2 ) {
            System.out.println("İsim ve Soyisim Alanı En Az 2 Karakter Olmalıdır.");
            return false;
        }
        return true;


    }



}
