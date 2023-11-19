package org.example;

import io.qameta.allure.junit4.DisplayName;
import org.example.config.SeleniumConfig;
import org.example.helper.UserApiHelper;
import org.example.helper.UserUiHelper;
import org.example.pageobject.LoginPage;
import org.example.pageobject.MainPage;
import org.example.pageobject.ProfilePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.config.PageUrl.LOGIN_URL;
import static org.junit.Assert.assertEquals;

public class LogoutTest {
    WebDriver webDriver;
    MainPage mainPage;
    LoginPage loginPage;
    UserApiHelper userApiHelper;
    UserUiHelper userUiHelper;
    ProfilePage profilePage;
    SeleniumConfig config;
    @Before
    public void setup() {
        //Создание нового пользователя через API
        userApiHelper = new UserApiHelper();
        userApiHelper.createUser();
        //Selenium
        config = new SeleniumConfig();
        webDriver = config.setup();
        //Pages
        userUiHelper = new UserUiHelper();
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        //Вход
        mainPage.clickLoginToAccountButton();
        loginPage.addEmail(userApiHelper.getEmail());
        loginPage.addPassword(userApiHelper.getPassword());
        loginPage.clickLoginButton();
        assertEquals("Оформить заказ", webDriver.findElement(mainPage.getCreateOrderButton()).getText());
    }

    @After
    public void deleteUser() {
        userApiHelper.getSendRequest().deleteUser(userApiHelper.getAccessToken());
        webDriver.quit();
    }

    @Test
    @DisplayName("Выход из приложения")
    public void logout() {

        //Выход
        profilePage = new ProfilePage(webDriver);
        mainPage.clickPersonalAccountButton();

        profilePage.clickLogoutButton();
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.urlToBe(LOGIN_URL));
        assertEquals("Войти", webDriver.findElement(loginPage.getLoginButton()).getText());
    }
}
