package com.da.dao;

import com.da.dto.CustomerDTO;

import java.io.Serializable;

public interface CustomerDAO extends Serializable,BaseDAO {

    void searchCustomer(CustomerDTO customerDTO);
}
