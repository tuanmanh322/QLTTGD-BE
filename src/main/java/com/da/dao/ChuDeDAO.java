package com.da.dao;

import com.da.dto.ChuDeSearchDTO;

import java.io.Serializable;

public interface ChuDeDAO extends Serializable,BaseDAO{
    void searchChuDe(ChuDeSearchDTO dto);
}
