package com.da.dao;

import com.da.dto.GiaoVienDTO;

import java.io.Serializable;


public interface GiaoVienDAO extends Serializable,BaseDAO{
    void searchGiaoVien(GiaoVienDTO dto);
}
