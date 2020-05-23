package com.da.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserTypeEnum {
    ADMIN(1, "ROLE_ADMIN"),
    CANDIDATE(2, "ROLE_CANDIDATE"),
    EMPLOYER(3,"ROLE_EMPLOYER"),
    TEACHER(4,"ROLE_TEACHER"),
    STUDENT(5,"ROLE_STUDENT");

    private int id;
    private String name;
}
