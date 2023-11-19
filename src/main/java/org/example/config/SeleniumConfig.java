package org.example.config;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class SeleniumConfig {
    WebDriver webDriver;
    @Step("Выполнение теста")
    public WebDriver setup() {
        //Yandex
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Yandex\\YandexBrowser\\Application\\browser.exe");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver/yandexdriver.exe");
        webDriver = new ChromeDriver(options);

        //Firefox
        //System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver/geckodriver.exe");
        //webDriver = new FirefoxDriver();

        //Chrome
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
        //webDriver = new ChromeDriver();

        webDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        return webDriver;
    }
}
