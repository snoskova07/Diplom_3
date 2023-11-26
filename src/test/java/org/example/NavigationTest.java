package org.example;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.example.config.ui.PageUrl.BASE_URL;
import static org.junit.Assert.assertEquals;

public class NavigationTest extends BaseTest {

    @Test
    @DisplayName("Переход по клику на «Личный кабинет» " +
            "из Конструктора под авторизованным пользователем")
    public void navigationToPersonalAccountByLoggedUser() {
        // Авторизация
        webDriver.get(BASE_URL);
        mainPage.clickLoginToAccountButton();
        loginPage.addEmail(userApiHelper.getEmail());
        loginPage.addPassword(userApiHelper.getPassword());
        loginPage.clickLoginButton();
        //Переход
        mainPage.clickPersonalAccountButton();
        profilePage.clickConstructorButton();
        mainPage.clickPersonalAccountButton();
        assertEquals("Выход", webDriver.findElement(profilePage.getLogoutButton()).getText());
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет» " +
            "из Конструктора под НЕ авторизованным пользователем")
    public void navigationToPersonalAccountByNotLoggedUser() {
       //Переход
        webDriver.get(BASE_URL);
        mainPage.clickPersonalAccountButton();
        assertEquals("Войти", webDriver.findElement(loginPage.getLoginButton()).getText());
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор»  " +
            "под авторизованным пользователем")
    public void navigationToConstructorByLoggedUser() {
        webDriver.get(BASE_URL);
        // Авторизация
        mainPage.clickLoginToAccountButton();
        loginPage.addEmail(userApiHelper.getEmail());
        loginPage.addPassword(userApiHelper.getPassword());
        loginPage.clickLoginButton();
        //Переход
        mainPage.clickPersonalAccountButton();
        profilePage.clickConstructorButton();
        assertEquals("Оформить заказ", webDriver.findElement(mainPage.getCreateOrderButton()).getText());
        assertEquals("Соберите бургер", webDriver.findElement(mainPage.getCreateBurgerHeader()).getText());
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор»  " +
            "под НЕ авторизованным пользователем")
    public void navigationToConstructorByNotLoggedUser() {
        webDriver.get(BASE_URL);
        //Переход
        mainPage.clickPersonalAccountButton();
        profilePage.clickConstructorButton();
        assertEquals("Войти в аккаунт", webDriver.findElement(mainPage.getLoginToAccountButton()).getText());
    }

    @Test
    @DisplayName("Переход по клику на Logo  " +
            "под авторизованным пользователем")
    public void clickByLogoByLoggedUser() {
        webDriver.get(BASE_URL);
        //Авторизация
        mainPage.clickLoginToAccountButton();
        loginPage.addEmail(userApiHelper.getEmail());
        loginPage.addPassword(userApiHelper.getPassword());
        loginPage.clickLoginButton();
        //Переход
        mainPage.clickPersonalAccountButton();
        profilePage.clickLogo();
        assertEquals("Оформить заказ", webDriver.findElement(mainPage.getCreateOrderButton()).getText());
        assertEquals("Соберите бургер", webDriver.findElement(mainPage.getCreateBurgerHeader()).getText());
    }
    @Test
    @DisplayName("Переход по клику на Logo " +
            "под НЕ авторизованным пользователем")
    public void clickByLogoByNotLoggedUser() {
        webDriver.get(BASE_URL);
        //Переход
        mainPage.clickPersonalAccountButton();
        loginPage.clickLogo();
        assertEquals("Войти в аккаунт", webDriver.findElement(mainPage.getLoginToAccountButton()).getText());
    }

}
