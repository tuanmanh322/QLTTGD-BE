package com.da.controller;

import com.da.dto.UserDTO;
import com.da.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile-detail")
    public ResponseEntity<UserDTO> getProfileDetail(){
        return new ResponseEntity<>(userService.getCurrentUserLogin(), HttpStatus.OK);
    }
}
