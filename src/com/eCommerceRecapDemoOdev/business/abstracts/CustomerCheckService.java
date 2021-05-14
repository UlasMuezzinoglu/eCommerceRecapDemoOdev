package com.eCommerceRecapDemoOdev.business.abstracts;

public interface CustomerCheckService {
    boolean passwordController(String password);
    boolean mailController(String mail);
    boolean nameController(String firstName, String lastName);

}
