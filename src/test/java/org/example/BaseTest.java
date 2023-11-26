package org.example;

import org.example.helper.api.UserApiHelper;
import org.example.helper.ui.UserUiHelper;
import org.example.pageobject.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    WebDriver webDriver;
    MainPage mainPage;
    LoginPage loginPage;
    ProfilePage profilePage;
    RegisterPage registerPage;
    ForgotPasswordPage forgotPasswordPage;
    UserApiHelper userApiHelper;
    UserUiHelper userUiHelper;
    @Before
    public void setup() {
        //Создание нового пользователя через API
        userApiHelper = new UserApiHelper();
        userApiHelper.createUser();
        //Selenium
        String browserName = System.getProperty("browserName");
        webDriver = WebDriverFactory.get(browserName);
        userUiHelper = new UserUiHelper();
        //Pages
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        profilePage = new ProfilePage(webDriver);
        registerPage = new RegisterPage(webDriver);
        forgotPasswordPage = new ForgotPasswordPage(webDriver);
    }

    @After
    public void deleteUser() {
        userApiHelper.getSendRequest().deleteUser(userApiHelper.getAccessToken());
        webDriver.quit();
    }
}
