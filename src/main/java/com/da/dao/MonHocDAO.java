package com.da.dao;

import com.da.dto.MonHocSearchDTO;

import java.io.Serializable;

public interface MonHocDAO extends Serializable,BaseDAO {
    void searchMH(MonHocSearchDTO dto);
}
