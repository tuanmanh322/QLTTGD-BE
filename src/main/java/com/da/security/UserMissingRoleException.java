package com.da.security;

import org.springframework.security.core.AuthenticationException;

public class UserMissingRoleException extends AuthenticationException {
    public UserMissingRoleException(String msg) {
        super(msg);
    }
}
