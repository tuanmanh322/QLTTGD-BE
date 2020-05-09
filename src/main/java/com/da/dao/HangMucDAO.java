package com.da.dao;

import com.da.dto.HangMucSearchDTO;

import java.io.Serializable;

public interface HangMucDAO extends Serializable,BaseDAO {
    void searchHangMuc(HangMucSearchDTO dto);
}
