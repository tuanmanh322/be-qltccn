package com.datn.qltccn.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserTypeEnum {
    ADMIN(1, "ROLE_ADMIN"),
    GUEST(2,"ROLE_GUEST");

    private int id;
    private String name;
}
