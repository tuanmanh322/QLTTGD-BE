package com.da.dao;

import com.da.dto.HangMucSearchDTO;
import com.da.dto.HocSinhDTO;

import java.io.Serializable;

public interface HocSinhDao extends Serializable,BaseDAO{
    void searchHocSinh(HocSinhDTO dto);
}
