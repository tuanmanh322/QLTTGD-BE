package com.da.service;

import com.da.dto.BaiVietDTO;
import com.da.dto.BaiVietSearchDTO;
import com.da.exception.ResultException;

public interface BaiVietService {
    void searchBaiViet(BaiVietSearchDTO dto);
    void add(BaiVietDTO dto) throws ResultException;
    void update(BaiVietDTO dto) throws ResultException;
    void delete(Integer id) throws ResultException;
    BaiVietDTO findById(Integer id);
}
