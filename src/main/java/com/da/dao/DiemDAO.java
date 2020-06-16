package com.da.dao;

import com.da.dto.DiemDTO;
import com.da.dto.DiemSearchDTO;

import java.io.Serializable;

public interface DiemDAO extends Serializable,BaseDAO {
    void searchDiem(DiemDTO dto);

    void searchDiemProfile(DiemSearchDTO dto, Integer idThe);
}
