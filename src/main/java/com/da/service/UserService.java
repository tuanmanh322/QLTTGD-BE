package com.da.service;

import com.da.common.CommonResult;
import com.da.dto.*;
import com.da.exception.ResultException;
import com.da.model.Users;

import java.util.List;

public interface UserService {
    void userSearch(UserSearchDTO userSearchDTO);

    UserDTO getCurrentUserLogin();

    void addByAdmin(UserDTO dto) throws ResultException;

    void editByAdmin(UserDTO dto);

    CommonResult addUser(UserDTO dto) throws ResultException;

    boolean checkEmail(String email);

    CommonResult register(UserDTO dto) throws ResultException;

    CommonResult updateProfile(UserDTO dto) throws ResultException;

    UserDTO getUserProfileEmp(Integer idUser);

    String getUserNameLogin();

    List<Users> getALl();

    void changePassword(PasswordChange passwordChange)throws ResultException;

    void forgotPassword(String  email)throws ResultException;

    void doLock(Integer idThe);
    void doUnLock(Integer idThe);

    CommonResult checkInUser(UserCheckinDTO userCheckinDTO);
}
