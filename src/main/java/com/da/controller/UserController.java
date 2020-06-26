package com.da.controller;

import com.da.common.CommonResult;
import com.da.dto.PasswordChange;
import com.da.dto.UserDTO;
import com.da.dto.UserSearchDTO;
import com.da.exception.ResultException;
import com.da.model.Users;
import com.da.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/check-email")
    public ResponseEntity<Boolean> checkMail(@RequestParam("email")String email){
        log.info("start rest to checkMail with {} : ",email);
        return new ResponseEntity<>( userService.checkEmail(email.trim()),HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<CommonResult> register(@RequestBody UserDTO dto) throws ResultException{
        log.info("start rest to register with {} : ",dto);
        return new ResponseEntity<>(userService.register(dto),HttpStatus.OK);
    }

    @PostMapping("/edit-profile")
    public ResponseEntity<CommonResult> edit(@ModelAttribute UserDTO dto) throws ResultException{
        log.info("start rest to edit with {} : ",dto);
        return new ResponseEntity<>(userService.updateProfile(dto),HttpStatus.OK);
    }

    @GetMapping("/profile-emp/{idUser}")
    public ResponseEntity<UserDTO> getProfileEMP(@PathVariable("idUser")Integer idUser){
        log.info("start rest to get getProfileEMP with: {}",idUser);
        return new ResponseEntity<>(userService.getUserProfileEmp(idUser),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAll(){
        log.info("start rest to get getAll ");
        return new ResponseEntity<>(userService.getALl(),HttpStatus.OK);
    }

    @PostMapping("/change-password")
    public ResponseEntity<Void> changePassword(@RequestBody PasswordChange passwordChange) throws ResultException{
        log.info("Start rest to changePassword with :{}",passwordChange);
        userService.changePassword(passwordChange);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/forgot-password")
    public ResponseEntity<Void> forgotPassword(@RequestParam("email")String email) throws ResultException{
        log.info("Start rest to forgotPassword with email:{}",email);
        userService.forgotPassword(email);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search-user")
    public ResponseEntity<UserSearchDTO> userSearchDTOResponseEntity(@RequestBody UserSearchDTO dto) {
        log.info("Start rest to userSearchDTOResponseEntity :{}",dto);
        userService.userSearch(dto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @PostMapping("/add-admin")
    public ResponseEntity<Void> userSearchDTOResponseEntity(@RequestBody UserDTO dto)throws ResultException {
        log.info("Start rest to userSearchDTOResponseEntity :{}",dto);
        userService.addByAdmin(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/lock-user/{idThe}")
    public ResponseEntity<Void> doLock(@PathVariable("idThe") Integer idThe) {
        log.info("Start rest to doLock :{}",idThe);
        userService.doLock(idThe);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/unlock-user/{idThe}")
    public ResponseEntity<Void> doUnLock(@PathVariable("idThe") Integer idThe) {
        log.info("Start rest to doUnLock :{}",idThe);
        userService.doUnLock(idThe);
        return ResponseEntity.ok().build();
    }
}
