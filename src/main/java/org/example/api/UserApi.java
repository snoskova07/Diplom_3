package org.example.api;
import io.qameta.allure.Step;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.apiModel.CreateUserRequest;
import org.example.apiModel.CreateUserResponse;
import org.example.apiModel.LoginUserRequest;
import org.example.apiModel.LoginUserResponse;
import static io.restassured.RestAssured.given;
import static org.example.config.ApiUrl.*;
public class UserApi {

    @Step("Отправка API запроса на создание пользователя")
    public String createUser(CreateUserRequest createUserRequest) {
        Response response = given()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .contentType(ContentType.JSON)
                .body(createUserRequest)
                .when()
                .post(REGISTER_USER_URL);
        response.then().statusCode(200);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        return createUserResponse.getAccessToken();
    }

    @Step("Отправка запроса на удаление пользователя")
    public Response deleteUser(String accessToken) {
        return given()
                .headers(
                        "Authorization",
                        accessToken)
                .contentType(ContentType.JSON)
                .when()
                .delete(DELETE_USER_URL);
    }

    @Step("Логин под пользователем")
    public Response loginUser(LoginUserRequest loginUserRequest) {
        return given()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .contentType(ContentType.JSON)
                .body(loginUserRequest)
                .when()
                .post(LOGIN_USER_URL);
    }
}
