package com.example.Alumni_Backend.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class RefreshTokenRequest {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
