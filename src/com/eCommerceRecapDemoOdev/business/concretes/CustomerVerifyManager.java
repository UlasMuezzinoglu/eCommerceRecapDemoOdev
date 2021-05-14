package com.eCommerceRecapDemoOdev.business.concretes;

import com.eCommerceRecapDemoOdev.business.abstracts.CustomerVerifyService;

public class CustomerVerifyManager implements CustomerVerifyService {
    @Override
    public void sendVerifyMail(String mail) {
        System.out.println("Doğrulama Kodu Gönderildi: "+mail);
    }

    @Override
    public boolean isClicked(String mail, String code) {
        String baseCode = "1234567";
        if(baseCode==code) {
            System.out.println("Mail Onayı Başarılı : " + mail);
            return true;
        }else {
            System.out.println("Mail Onaylanmadı."+ mail);
            return false;
        }

    }
}
