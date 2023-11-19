package org.example.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.example.config.PageUrl.BASE_URL;

public class MainPage {

    WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.get(BASE_URL);
    }

    //Локаторы общие
    private By createOrderButton = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    private By loginToAccountButton = By.xpath(".//button[contains(@class, 'button_button__33qZ0')]");
    private By personalAccountButton = By.xpath(".//a[@href='/account']/p[@class = 'AppHeader_header__linkText__3q_va ml-2']");
    private By createBurgerHeader = By.xpath(".//h1[@class = 'text text_type_main-large mb-5 mt-10']");

    //Заголовки разделов
    private By bunTitle = By.xpath(".//h2[@class = 'text text_type_main-medium mb-6 mt-10'][1]");
    private By sauceTitle = By.xpath(".//h2[@class = 'text text_type_main-medium mb-6 mt-10'][2]");
    private By mainTitle = By.xpath(".//h2[@class = 'text text_type_main-medium mb-6 mt-10'][3]");

    //Выбор табы, контрола...
    private By bunControl = By.xpath("//div[starts-with(@class,'tab_tab__1SPyG')][1]");
    private By sauceControl = By.xpath("//div[starts-with(@class,'tab_tab__1SPyG')][2]");
    private By mainControl = By.xpath("//div[starts-with(@class,'tab_tab__1SPyG')][3]");

    //Getters
    public By getLoginToAccountButton() {
        return loginToAccountButton;
    }
    public By getCreateOrderButton() {
        return createOrderButton;
    }
    public By getCreateBurgerHeader() {
        return createBurgerHeader;
    }

    //Методы
    public void clickLoginToAccountButton() {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        WebElement button = webDriver.findElement(loginToAccountButton);
        executor.executeScript("arguments[0].click()", button);
    }

    public void clickPersonalAccountButton() {
        new WebDriverWait(webDriver, (5)).until(ExpectedConditions.elementToBeClickable(personalAccountButton));
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        WebElement button = webDriver.findElement(personalAccountButton);
        executor.executeScript("arguments[0].click()", button);
    }

    //Клик по bunTitle
    public void clickBunControl() {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        WebElement bun = webDriver.findElement(bunControl);
        executor.executeScript("arguments[0].click()", bun);
    }

    //Клик по sauceTitle
    public void clickSauceControl() {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        WebElement sauce = webDriver.findElement(sauceControl);
        executor.executeScript("arguments[0].click()", sauce);
    }

    //Клик по mainTitle
    public void clickMainControl() {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        WebElement main = webDriver.findElement(mainControl);
        executor.executeScript("arguments[0].click()", main);
    }

    // метод проверяет, что выбрана секция Булки
    public boolean checkBunIsEnabled() {
        return webDriver.findElement(bunTitle).isDisplayed();
    }

    // метод проверяет, что выбрана секция Начинки
    public boolean checkMainIsEnabled() {
        return webDriver.findElement(mainTitle).isDisplayed();

    }

    // метод проверяет, что выбрана секция Соусы
    public boolean checkSauceIsEnabled() {
        return webDriver.findElement(sauceTitle).isDisplayed();
    }
}
