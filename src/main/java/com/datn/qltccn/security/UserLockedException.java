package com.datn.qltccn.security;

import org.springframework.security.core.AuthenticationException;

public class UserLockedException extends AuthenticationException {
    public UserLockedException(String msg) {
        super(msg);
    }
}
