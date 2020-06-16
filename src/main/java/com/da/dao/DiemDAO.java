package com.da.dao;

import com.da.dto.DiemDTO;
import com.da.dto.DiemSearchDTO;
import com.da.dto.DiemToExcelDTO;

import java.io.Serializable;
import java.util.List;

public interface DiemDAO extends Serializable,BaseDAO {
    void searchDiem(DiemDTO dto);

    void searchDiemProfile(DiemSearchDTO dto, Integer idThe);

    List<DiemToExcelDTO> getAllByIdThe(Integer idThe);
}
