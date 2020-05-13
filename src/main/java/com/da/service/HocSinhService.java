package com.da.service;

import com.da.dto.HocSinhDTO;
import com.da.exception.ResultException;

public interface HocSinhService {
    void searchHocSinh(HocSinhDTO dto);
    void add(HocSinhDTO dto) throws ResultException;
    void update(HocSinhDTO dto)throws ResultException;
    void delete(Integer id)throws ResultException;
    HocSinhDTO findById(Integer id);
}
