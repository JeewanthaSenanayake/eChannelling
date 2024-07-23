package com.authentication_authorization.Login.ResponseObjects;

import java.util.List;
import java.util.UUID;

public class LoginResponse {
    
    UUID id;
    List<String> userRoles;
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<String> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<String> userRoles) {
        this.userRoles = userRoles;
    }
}
