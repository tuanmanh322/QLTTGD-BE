package com.da.service;

import com.da.dto.GiaoVienDTO;

import com.da.exception.ResultException;

public interface GiaoVienService {
    void searchGiaoVien(GiaoVienDTO dto);
    void add(GiaoVienDTO dto) throws ResultException;
    void update(GiaoVienDTO dto)throws ResultException;
    void delete(Integer id)throws ResultException;
    GiaoVienDTO findById(Integer id);
}
