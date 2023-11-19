package org.example;

import io.qameta.allure.junit4.DisplayName;
import org.example.config.SeleniumConfig;
import org.example.pageobject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ConstructorTest {
    WebDriver webDriver;
    SeleniumConfig config;
    MainPage mainPage;
    @Before
    public void setup() {
        config = new SeleniumConfig();
        webDriver = config.setup();
        mainPage = new MainPage(webDriver);
    }
    @After
    public void closeBrowser() {
        webDriver.quit();
    }

    @Test
    @DisplayName("Переход на Начинки")
    public void Main() {
        mainPage.clickMainControl();
        mainPage.checkMainIsEnabled();
    }
    @Test
    @DisplayName("Переход на Соусы")
    public void Sauce() {
        mainPage.clickSauceControl();
        mainPage.checkSauceIsEnabled();
    }
    @Test
    @DisplayName("Переход на Булки")
    public void Bun() {
        mainPage.clickBunControl();
        mainPage.checkBunIsEnabled();
    }
}
