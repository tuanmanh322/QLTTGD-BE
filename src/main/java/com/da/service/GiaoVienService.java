package com.da.service;

import com.da.common.CommonResult;
import com.da.dto.GiaoVienDTO;

import com.da.exception.ResultException;

public interface GiaoVienService {
    void searchGiaoVien(GiaoVienDTO dto);
    CommonResult add(GiaoVienDTO dto) throws ResultException;
    void update(GiaoVienDTO dto)throws ResultException;
    void delete(Integer id)throws ResultException;
    GiaoVienDTO findById(Integer id);

    boolean checkMaGV(String maGV);

    Integer countGVALL();

    Integer countGVActive();
}
