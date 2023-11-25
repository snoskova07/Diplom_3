package org.example;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.example.config.ui.PageUrl.BASE_URL;

public class ConstructorTest extends BaseTest {
    @Test
    @DisplayName("Переход на Начинки")
    public void Main() {
        webDriver.get(BASE_URL);
        mainPage.clickMainControl();
        mainPage.checkMainIsEnabled();
    }
    @Test
    @DisplayName("Переход на Соусы")
    public void Sauce() {
        webDriver.get(BASE_URL);
        mainPage.clickSauceControl();
        mainPage.checkSauceIsEnabled();
    }
    @Test
    @DisplayName("Переход на Булки")
    public void Bun() {
        webDriver.get(BASE_URL);
        mainPage.clickBunControl();
        mainPage.checkBunIsEnabled();
    }
}
