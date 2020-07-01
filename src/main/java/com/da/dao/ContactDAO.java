package com.da.dao;

import com.da.dto.ContactSearchDTO;

import java.io.Serializable;

public interface ContactDAO extends Serializable,BaseDAO {

    void searchContact(ContactSearchDTO contactSearchDTO);
}
