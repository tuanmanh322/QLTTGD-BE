package com.da.service;

import com.da.dto.DiemDTO;

import com.da.exception.ResultException;

public interface DiemService {
    void searchDiem(DiemDTO dto);
    void add(DiemDTO dto) throws ResultException;
    void update(DiemDTO dto)throws ResultException;
    void delete(Integer id)throws ResultException;
    DiemDTO findById(Integer id);
}
