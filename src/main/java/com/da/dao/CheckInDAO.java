package com.da.dao;

import com.da.dto.CheckInDTO;

import java.io.Serializable;


public interface CheckInDAO  extends Serializable,BaseDAO{
    void searchCheckIn(CheckInDTO dto);
}
