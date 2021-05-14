package com.eCommerceRecapDemoOdev.business.abstracts;

public interface CustomerVerifyService {
    void sendVerifyMail(String mail);
    boolean isClicked(String mail, String code);
}
