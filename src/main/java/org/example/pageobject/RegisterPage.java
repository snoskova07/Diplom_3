package org.example.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.config.ui.PageUrl.REGISTER_URL;

public class RegisterPage {
    WebDriver webDriver;
    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.get(REGISTER_URL);
    }

    //Локаторы
    private By nameInput = By.xpath(".//fieldset[@class = 'Auth_fieldset__1QzWN mb-6'][1]//input[@name = 'name']");
    private By emailInput = By.xpath(".//fieldset[@class = 'Auth_fieldset__1QzWN mb-6'][2]//input[@name = 'name']");
    private By passwordInput = By.xpath(".//input[@type = 'password']");
    private By registrationButton = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private By invalidPasswordLabel = By.xpath(".//div[@class = 'input__container']//p[@class = 'input__error text_type_main-default']");
    private By loginLink = By.xpath(".//a[@href = '/login']");



    //Getters
    public By getNameInput() {
        return nameInput;
    }

    public By getEmailInput() {
        return emailInput;
    }

    public By getPasswordInput() {
        return passwordInput;
    }

    public By getRegistrationButton() {
        return registrationButton;
    }

    public By getInvalidPasswordLabel() {
        return invalidPasswordLabel;
    }

    //Методы
    @Step("Ввод имени")
     public void addName(String name) {
        webDriver.findElement(nameInput).sendKeys(name);
    }

    @Step("Ввод email")
    public void addEmail(String email) {
        webDriver.findElement(emailInput).sendKeys(email);
    }

    @Step("Ввод пароля")
    public void addPassword(String password) {
        webDriver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Нажатие на кнопу Зарегистрироваться")
    public void clickRegistrationButton() {
        webDriver.findElement(registrationButton).click();
    }

    @Step("Нажатие на ссылку Войти")
    public void clickLoginLink() {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        WebElement link = webDriver.findElement(loginLink);
        executor.executeScript("arguments[0].click()", link);
    }

}
