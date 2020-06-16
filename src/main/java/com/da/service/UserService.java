package com.da.service;

import com.da.common.CommonResult;
import com.da.dto.UserDTO;
import com.da.exception.ResultException;
import com.da.model.Users;

import java.util.List;

public interface UserService {
    UserDTO getCurrentUserLogin();

    CommonResult addUser(UserDTO dto) throws ResultException;

    boolean checkEmail(String email);

    CommonResult register(UserDTO dto) throws ResultException;

    CommonResult updateProfile(UserDTO dto) throws ResultException;

    UserDTO getUserProfileEmp(Integer idUser);

    String getUserNameLogin();

    List<Users> getALl();
}
