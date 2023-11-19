package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    WebDriver webDriver;
    public ProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    //Logout
    private By logoutButton = By.xpath(".//button[@class = 'Account_button__14Yp3 text text_type_main-medium text_color_inactive']");
    private By constructorButton = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2']");
    private By logoHeader = By.xpath(".//a[@href = '/']");

    //Getters
    public By getLogoutButton() {
        return logoutButton;
    }

    public void clickLogoutButton() {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        WebElement button = webDriver.findElement(logoutButton);
        executor.executeScript("arguments[0].click()", button);
    }

    public void clickConstructorButton() {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        WebElement button = webDriver.findElement(constructorButton);
        executor.executeScript("arguments[0].click()", button);
    }

    public void clickLogo() {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        WebElement logo = webDriver.findElement(logoHeader);
        executor.executeScript("arguments[0].click()", logo);
    }
}
