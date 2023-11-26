package org.example;

import io.qameta.allure.junit4.DisplayName;
import org.example.pageobject.ForgotPasswordPage;
import org.example.pageobject.RegisterPage;
import org.junit.Test;
import static org.example.config.ui.PageUrl.*;
import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {
   // вход по кнопке «Войти в аккаунт» на главной
   @Test
   @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
   public void loginFromMainPage() {
       webDriver.get(BASE_URL);
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
       webDriver.get(BASE_URL);
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
       webDriver.get(REGISTER_URL);
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
       webDriver.get(FORGOT_PASSWORD_URL);
       forgotPasswordPage = new ForgotPasswordPage(webDriver);
       forgotPasswordPage.clickLoginLink();
       loginPage.addEmail(userApiHelper.getEmail());
       loginPage.addPassword(userApiHelper.getPassword());
       loginPage.clickLoginButton();
       assertEquals("Оформить заказ", webDriver.findElement(mainPage.getCreateOrderButton()).getText());
   }

}
