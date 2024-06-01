package com.example.flightsearchapi.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {

    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN");

    private String value;

    RoleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }


    public String getAuthority() {
        return name();
    }


}
