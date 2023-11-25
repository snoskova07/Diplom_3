package org.example;

import org.example.helper.ui.GeneratorHelper;
import org.example.pageobject.LoginPage;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.example.config.ui.PageUrl.*;
import static org.junit.Assert.*;

public class RegistrationTest extends BaseTest {
    GeneratorHelper generatorHelper;
    String name;
    String email;
    String password;

    @Test
    public void successRegistration() {
        generatorHelper = new GeneratorHelper();
        name = generatorHelper.generateUserName();
        email =  generatorHelper.generateUserEmail();
        password = generatorHelper.generateUserPassword();
        webDriver.get(REGISTER_URL);
        registerPage.addName(name);
        registerPage.addEmail(email);
        registerPage.addPassword(password);
        registerPage.clickRegistrationButton();
        loginPage = new LoginPage(webDriver);
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.urlToBe(LOGIN_URL));
        assertEquals("Войти", webDriver.findElement(loginPage.getLoginButton()).getText());
    }

    @Test
    public void failedRegistrationWithShortPassword() {
        String name = generatorHelper.generateUserName();
        String email = generatorHelper.generateUserEmail();
        String password = "12345";
        System.out.println(name);
        System.out.println(email);
        System.out.println(password);
        webDriver.get(REGISTER_URL);
        registerPage.addName(name);
        registerPage.addEmail(email);
        registerPage.addPassword(password);
        registerPage.clickRegistrationButton();
        assertEquals("Некорректный пароль", webDriver.findElement(registerPage.getInvalidPasswordLabel()).getText());
    }

}
