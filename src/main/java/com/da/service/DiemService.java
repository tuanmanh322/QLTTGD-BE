package com.da.service;

import com.da.dto.DiemActionDTO;
import com.da.dto.DiemDTO;

import com.da.dto.DiemSearchDTO;
import com.da.dto.DiemToExcelDTO;
import com.da.exception.ResultException;

import java.util.List;

public interface DiemService {
    void searchDiem(DiemDTO dto);
    void add(DiemActionDTO dto) throws ResultException;
    void update(DiemActionDTO dto)throws ResultException;
    void delete(Integer id)throws ResultException;
    DiemDTO findById(Integer id);

    void searchDiemByProfile(DiemSearchDTO dto);

    List<DiemToExcelDTO> getAllByIdUser();
}
