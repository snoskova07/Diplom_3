package org.example.apiModel;

public class LoginUserRequest {
    public String email;
    public String password;

    public LoginUserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
