package org.example.helper;

import org.example.pageobject.LoginPage;

public class UserUiHelper {
    public void login(LoginPage loginPage, String email, String password) {
        loginPage.addEmail(email);
        loginPage.addPassword(password);
        loginPage.clickLoginButton();
    }
}
