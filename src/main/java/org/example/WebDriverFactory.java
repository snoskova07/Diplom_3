package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    static WebDriver webDriver;

    public static WebDriver get(String browserName) {
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
                webDriver = new ChromeDriver();

                webDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
                return webDriver;
            case "yandex":
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Program Files (x86)\\Yandex\\YandexBrowser\\Application\\browser.exe");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver/yandexdriver.exe");
                webDriver = new ChromeDriver(options);
                webDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
                return webDriver;
            default:
                throw new RuntimeException("Browser is not detected");
        }
    }
}

