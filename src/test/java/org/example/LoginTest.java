package org.example;

import io.qameta.allure.junit4.DisplayName;
import org.example.config.SeleniumConfig;
import org.example.helper.UserApiHelper;
import org.example.pageobject.ForgotPasswordPage;
import org.example.pageobject.LoginPage;
import org.example.pageobject.MainPage;
import org.example.pageobject.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class LoginTest {
    WebDriver webDriver;
    MainPage mainPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    ForgotPasswordPage forgotPasswordPage;
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
    }

    @After
    public void deleteAndClose() {
        userApiHelper.getSendRequest().deleteUser(userApiHelper.getAccessToken());
        webDriver.quit();
    }

   // вход по кнопке «Войти в аккаунт» на главной
   @Test
   @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
   public void loginFromMainPage() {
       mainPage.clickLoginToAccountButton();
       loginPage.addEmail(userApiHelper.getEmail());
       loginPage.addPassword(userApiHelper.getPassword());
       loginPage.clickLoginButton();
       assertEquals("Оформить заказ", webDriver.findElement(mainPage.getCreateOrderButton()).getText());
   }

   // вход через кнопку «Личный кабинет»
   @Test
   @DisplayName("Вход через кнопку «Личный кабинет»")
   public void loginByPersonalAccountButton() {
       mainPage.clickPersonalAccountButton();
       loginPage.addEmail(userApiHelper.getEmail());
       loginPage.addPassword(userApiHelper.getPassword());
       loginPage.clickLoginButton();
       assertEquals("Оформить заказ", webDriver.findElement(mainPage.getCreateOrderButton()).getText());
   }

   // вход через кнопку в форме регистрации
   @Test
   @DisplayName("Вход через линку на форме регистрации")
   public void loginByRegistrationLink() {
       registerPage = new RegisterPage(webDriver);
       registerPage.clickLoginLink();
       loginPage.addEmail(userApiHelper.getEmail());
       loginPage.addPassword(userApiHelper.getPassword());
       loginPage.clickLoginButton();
       assertEquals("Оформить заказ", webDriver.findElement(mainPage.getCreateOrderButton()).getText());
   }

   // Вход через кнопку в форме восстановления пароля
   @Test
   @DisplayName("Вход через кнопку в форме восстановления пароля")
   public void loginByPasswordRecoveryLink() {
       forgotPasswordPage = new ForgotPasswordPage(webDriver);
       forgotPasswordPage.clickLoginLink();
       loginPage.addEmail(userApiHelper.getEmail());
       loginPage.addPassword(userApiHelper.getPassword());
       loginPage.clickLoginButton();
       assertEquals("Оформить заказ", webDriver.findElement(mainPage.getCreateOrderButton()).getText());
   }

}
