package org.example.helper;

import org.example.api.UserApi;
import org.example.apiModel.CreateUserRequest;

public class UserApiHelper {
    GeneratorHelper generatorHelper;
    String accessToken;
    CreateUserRequest createUserRequest;
    UserApi sendRequest;
    String name;
    String email;
    String password;

    //Getters
    public String getAccessToken() {
        return accessToken;
    }

    public CreateUserRequest getCreateUserRequest() {
        return createUserRequest;
    }

    public UserApi getSendRequest() {
        return sendRequest;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    //Methods
    private void generateUserCredentials() {
        generatorHelper = new GeneratorHelper();
        name = generatorHelper.generateUserName();
        email = generatorHelper.generateUserEmail();
        password = generatorHelper.generateUserPassword();
    }

    public void createUser() {
        this.generateUserCredentials();
        sendRequest = new UserApi();
        createUserRequest = new CreateUserRequest(email, password, name);
        accessToken = sendRequest.createUser(createUserRequest);
    }

}
