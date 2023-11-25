package org.example.helper.api;

import org.example.client.UserApiClient;
import org.example.helper.ui.GeneratorHelper;
import org.example.model.api.CreateUserRequest;

public class UserApiHelper {
    GeneratorHelper generatorHelper;
    String accessToken;
    CreateUserRequest createUserRequest;
    UserApiClient sendRequest;
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

    public UserApiClient getSendRequest() {
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
        sendRequest = new UserApiClient();
        createUserRequest = new CreateUserRequest(email, password, name);
        accessToken = sendRequest.createUser(createUserRequest);
    }

}
