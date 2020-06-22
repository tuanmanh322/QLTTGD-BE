package com.da;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MainTest {

    public static void main(String[] args) {
        String old = "$2a$10$YO.97h5NV0ioJwMF/L4xZusY4jnBefM2u2YdjKNlWnyPravWNj2Ly";
        String newpw = "123456";

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (passwordEncoder.matches(newpw,passwordEncoder.encode(newpw))) {
            System.out.println("true");
        } else {
            System.out.println("False");
        }
    }
}
