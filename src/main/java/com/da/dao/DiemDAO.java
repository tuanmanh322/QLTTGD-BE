package com.da.dao;

import com.da.dto.DiemDTO;

import java.io.Serializable;

public interface DiemDAO extends Serializable,BaseDAO {
    void searchDiem(DiemDTO dto);
}
