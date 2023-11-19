package org.example.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.config.PageUrl.LOGIN_URL;
public class LoginPage {

    WebDriver webDriver;
    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // Локаторы
    private By emailInput = By.xpath("//input[@name = 'name']");
    private By passwordInput = By.xpath("//input[@type = 'password']");
    private By loginButton = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private By logoHeader = By.xpath(".//a[@href = '/']");

//Getters
    public By getEmailInput() {
        return emailInput;
    }

    public By getPasswordInput() {
        return passwordInput;
    }

    public By getLoginButton() {
        return loginButton;
    }

    //Методы
    public void addEmail(String email) {
        webDriver.findElement(emailInput).sendKeys(email);
    }
    public void addPassword(String password) {
        webDriver.findElement(passwordInput).sendKeys(password);
    }
    public void clickLoginButton() {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        WebElement button = webDriver.findElement(loginButton);
        executor.executeScript("arguments[0].click()", button);
    }

    public void clickLogo() {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        WebElement logo = webDriver.findElement(logoHeader);
        executor.executeScript("arguments[0].click()", logo);
    }

}
