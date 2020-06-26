package com.da.dao;

import com.da.dto.UserSearchDTO;

import java.io.Serializable;

public interface UserDAO extends Serializable,BaseDAO {

    void searchUser(UserSearchDTO userSearchDTO);

}
