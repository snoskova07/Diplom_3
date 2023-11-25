package org.example.pageobject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver webDriver;

    // Локаторы
    private By emailInput = By.xpath("//input[@name = 'name']");
    private By passwordInput = By.xpath("//input[@type = 'password']");
    private By loginButton = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private By logoHeader = By.xpath(".//a[@href = '/']");

    //Конструктор
    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

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
    @Step("Ввод email")
    public void addEmail(String email) {
        webDriver.findElement(emailInput).sendKeys(email);
    }

    @Step("Ввод пароля")
    public void addPassword(String password) {
        webDriver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Нажатие на кнопку Войти")
    public void clickLoginButton() {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        WebElement button = webDriver.findElement(loginButton);
        executor.executeScript("arguments[0].click()", button);
    }
    @Step("Нажатие на Лого")
    public void clickLogo() {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        WebElement logo = webDriver.findElement(logoHeader);
        executor.executeScript("arguments[0].click()", logo);
    }

}
