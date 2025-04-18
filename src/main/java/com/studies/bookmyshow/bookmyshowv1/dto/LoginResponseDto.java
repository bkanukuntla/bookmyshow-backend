package com.studies.bookmyshow.bookmyshowv1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto{
    private String email;
    private String token;

    public LoginResponseDto() {
    }

    public LoginResponseDto(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
