package com.da.controller;

import com.da.common.CommonResult;
import com.da.dto.UserDTO;
import com.da.exception.ResultException;
import com.da.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final Logger log =LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile-detail")
    public ResponseEntity<UserDTO> getProfileDetail(){
        log.info("start rest to getProfileDetail");
        return new ResponseEntity<>(userService.getCurrentUserLogin(), HttpStatus.OK);
    }

    @GetMapping("/check-mail")
    public ResponseEntity<Boolean> checkMail(@RequestParam("email")String email){
        log.info("start rest to checkMail with {} : ",email);
        return new ResponseEntity<>( userService.checkEmail(email),HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<CommonResult> add(@ModelAttribute UserDTO dto) throws ResultException{
        log.info("start rest to add with {} : ",dto);
        return new ResponseEntity<>(userService.addUser(dto),HttpStatus.OK);
    }
}
