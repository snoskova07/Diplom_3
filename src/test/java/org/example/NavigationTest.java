package org.example;

import io.qameta.allure.junit4.DisplayName;
import org.example.config.SeleniumConfig;
import org.example.helper.UserApiHelper;
import org.example.pageobject.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;

public class NavigationTest {
    WebDriver webDriver;
    MainPage mainPage;
    LoginPage loginPage;
    ProfilePage profilePage;
    UserApiHelper userApiHelper;
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
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        profilePage = new ProfilePage(webDriver);

    }

    @After
    public void deleteUser() {
        userApiHelper.getSendRequest().deleteUser(userApiHelper.getAccessToken());
        webDriver.quit();
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет» " +
            "из Конструктора под авторизованным пользователем")
    public void navigationToPersonalAccountByLoggedUser() {
        // Авторизация
        mainPage.clickLoginToAccountButton();
        loginPage.addEmail(userApiHelper.getEmail());
        loginPage.addPassword(userApiHelper.getPassword());
        loginPage.clickLoginButton();
        assertEquals("Оформить заказ", webDriver.findElement(mainPage.getCreateOrderButton()).getText());
        assertEquals("Соберите бургер", webDriver.findElement(mainPage.getCreateBurgerHeader()).getText());
        //Переход
        mainPage.clickPersonalAccountButton();
        profilePage.clickConstructorButton();
        mainPage.clickPersonalAccountButton();
        assertEquals("Выход", webDriver.findElement(profilePage.getLogoutButton()).getText());
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет» " +
            "из Конструктора под НЕ авторизованным пользователем")
    public void navigationToPersonalAccountByNotLoggedUser() {
       //Переход
        mainPage.clickPersonalAccountButton();
        assertEquals("Войти", webDriver.findElement(loginPage.getLoginButton()).getText());
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор»  " +
            "под авторизованным пользователем")
    public void navigationToConstructorByLoggedUser() {
        // Авторизация
        mainPage.clickLoginToAccountButton();
        loginPage.addEmail(userApiHelper.getEmail());
        loginPage.addPassword(userApiHelper.getPassword());
        loginPage.clickLoginButton();
        assertEquals("Оформить заказ", webDriver.findElement(mainPage.getCreateOrderButton()).getText());
        //Переход
        mainPage.clickPersonalAccountButton();
        profilePage.clickConstructorButton();
        assertEquals("Оформить заказ", webDriver.findElement(mainPage.getCreateOrderButton()).getText());
        assertEquals("Соберите бургер", webDriver.findElement(mainPage.getCreateBurgerHeader()).getText());
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор»  " +
            "под НЕ авторизованным пользователем")
    public void navigationToConstructorByNotLoggedUser() {
        //Переход
        mainPage.clickPersonalAccountButton();
        profilePage.clickConstructorButton();
        assertEquals("Войти в аккаунт", webDriver.findElement(mainPage.getLoginToAccountButton()).getText());
    }

    @Test
    @DisplayName("Переход по клику на Logo  " +
            "под авторизованным пользователем")
    public void clickByLogoByLoggedUser() {
        //Авторизация
        mainPage.clickLoginToAccountButton();
        loginPage.addEmail(userApiHelper.getEmail());
        loginPage.addPassword(userApiHelper.getPassword());
        loginPage.clickLoginButton();
        assertEquals("Оформить заказ", webDriver.findElement(mainPage.getCreateOrderButton()).getText());
        //Переход
        mainPage.clickPersonalAccountButton();
        profilePage.clickLogo();
        assertEquals("Оформить заказ", webDriver.findElement(mainPage.getCreateOrderButton()).getText());
        assertEquals("Соберите бургер", webDriver.findElement(mainPage.getCreateBurgerHeader()).getText());
    }
    @Test
    @DisplayName("Переход по клику на Logo " +
            "под НЕ авторизованным пользователем")
    public void clickByLogoByNotLoggedUser() {
        //Переход
        mainPage.clickPersonalAccountButton();
        loginPage.clickLogo();
        assertEquals("Войти в аккаунт", webDriver.findElement(mainPage.getLoginToAccountButton()).getText());
    }

}
