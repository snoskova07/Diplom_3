package org.example.helper;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
public class GeneratorHelper {
    public static String generateUserName() {
        String name = "name" + RandomStringUtils.randomAlphabetic(3);
        return name;
    }

    public static String generateUserEmail() {
        String email = "mail" + RandomStringUtils.randomAlphabetic(2).toLowerCase() + '@' + RandomStringUtils.randomAlphabetic(5).toLowerCase() + ".qwe";
        return email;
    }

    public static String generateUserPassword() {
        String password = "passwd" + RandomStringUtils.randomAlphabetic(3);
        return password;
    }
}
