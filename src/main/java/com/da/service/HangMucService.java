package com.da.service;

import com.da.dto.HangMucCDDTO;
import com.da.dto.HangMucDTO;
import com.da.dto.HangMucSearchDTO;
import com.da.exception.ResultException;

import java.util.List;

public interface HangMucService {
    void searchHangMuc(HangMucSearchDTO dto);
    void add(HangMucDTO dto) throws ResultException;
    void update(HangMucDTO dto)throws ResultException;
    void delete(Integer id)throws ResultException;
    HangMucDTO findById(Integer id);

    List<HangMucCDDTO> getListHMwithCD();
}
