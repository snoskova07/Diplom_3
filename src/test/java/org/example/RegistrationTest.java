package org.example;

import io.restassured.response.Response;
import org.example.api.UserApi;
import org.example.apiModel.LoginUserRequest;
import org.example.apiModel.LoginUserResponse;
import org.example.config.SeleniumConfig;
import org.example.helper.GeneratorHelper;
import org.example.helper.UserApiHelper;
import org.example.pageobject.LoginPage;
import org.example.pageobject.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.config.PageUrl.LOGIN_URL;
import static org.junit.Assert.*;

public class RegistrationTest {
    WebDriver webDriver;
    RegisterPage registerPage;
    LoginPage loginPage;
    GeneratorHelper generatorHelper;
    SeleniumConfig config;
    UserApi userApi;
    String name;
    String email;
    String password;
    String accessToken;
    @Before
    public void setup() {
        //Selenium
        config = new SeleniumConfig();
        webDriver = config.setup();
        //Pages
        registerPage = new RegisterPage(webDriver);
        generatorHelper = new GeneratorHelper();
    }

    @After
    public void closeBrowser() {
        webDriver.quit();
    }

    @Test
    public void successRegistration() {
        name = generatorHelper.generateUserName();
        email =  generatorHelper.generateUserEmail();
        password = generatorHelper.generateUserPassword();

        registerPage.addName(name);
        registerPage.addEmail(email);
        registerPage.addPassword(password);
        registerPage.clickRegistrationButton();
        loginPage = new LoginPage(webDriver);
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.urlToBe(LOGIN_URL));
        assertEquals("Войти", webDriver.findElement(loginPage.getLoginButton()).getText());

        //Логин под пользователем через API и уделание пользователя
        LoginUserRequest loginUserRequest = new LoginUserRequest(email, password);
        userApi = new UserApi();
        Response response = userApi.loginUser(loginUserRequest);
        LoginUserResponse loginUserResponse = response.as(LoginUserResponse.class);
        accessToken = loginUserResponse.getAccessToken();
        userApi.deleteUser(accessToken);
    }

    @Test
    public void failedRegistrationWithShortPassword() {
        String name = generatorHelper.generateUserName();
        String email = generatorHelper.generateUserEmail();
        String password = "12345";
        System.out.println(name);
        System.out.println(email);
        System.out.println(password);

        registerPage.addName(name);
        registerPage.addEmail(email);
        registerPage.addPassword(password);
        registerPage.clickRegistrationButton();
        assertEquals("Некорректный пароль", webDriver.findElement(registerPage.getInvalidPasswordLabel()).getText());
    }

}
