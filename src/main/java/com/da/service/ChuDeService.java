package com.da.service;

import com.da.dto.ChuDeCountDTO;
import com.da.dto.ChuDeDTO;
import com.da.dto.ChuDeSearchDTO;
import com.da.exception.ResultException;

import java.util.List;


public interface ChuDeService {
    void searchChuDe(ChuDeSearchDTO dto);
    void add(ChuDeDTO dto) throws ResultException;
    void update(ChuDeDTO dto)throws ResultException;
    void delete(Integer id)throws ResultException;
    ChuDeDTO findById(Integer id);

    List<ChuDeCountDTO> getChuDeAndCount();
}
