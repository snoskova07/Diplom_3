package org.example;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;
import static org.example.config.ui.PageUrl.*;
import static org.junit.Assert.assertEquals;

public class LogoutTest extends BaseTest {
    @Test
    @DisplayName("Выход из приложения")
    public void logout() throws InterruptedException {
        //Вход
        webDriver.get(BASE_URL);
        mainPage.clickLoginToAccountButton();
        loginPage.addEmail(userApiHelper.getEmail());
        loginPage.addPassword(userApiHelper.getPassword());
        loginPage.clickLoginButton();
        sleep(1000);
        //Выход
        mainPage.clickPersonalAccountButton();
        profilePage.clickLogoutButton();
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.urlToBe(LOGIN_URL));
        assertEquals("Войти", webDriver.findElement(loginPage.getLoginButton()).getText());
    }
}
