package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.config.PageUrl.FORGOT_PASSWORD_URL;

public class ForgotPasswordPage {
    WebDriver webDriver;
    public ForgotPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.get(FORGOT_PASSWORD_URL);
    }
    private By loginLink = By.xpath(".//a[@href = '/login']");

    public void clickLoginLink() {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        WebElement link = webDriver.findElement(loginLink);
        executor.executeScript("arguments[0].click()", link);
    }
}
