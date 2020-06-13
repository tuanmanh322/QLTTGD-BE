package com.da.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserTypeEnum {
    ADMIN(1, "ROLE_ADMIN"),
    TEACHER(2,"ROLE_TEACHER"),
    STUDENT(3,"ROLE_STUDENT");

    private int id;
    private String name;
}
