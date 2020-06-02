package com.da.service;

import com.da.dto.BaiVietDTO;
import com.da.dto.BaiVietSearchDTO;
import com.da.exception.ResultException;

import java.util.List;

public interface BaiVietService {
    void searchBaiViet(BaiVietSearchDTO dto);
    void add(BaiVietDTO dto) throws ResultException;
    void update(BaiVietDTO dto) throws ResultException;
    void delete(Integer id) throws ResultException;
    BaiVietDTO findById(Integer id);

    List<BaiVietDTO> getBaiVietWithComment();

    List<BaiVietDTO> getBVandTotalComment();

    BaiVietDTO getDetailBVCMREM(Integer idBV);

    List<BaiVietDTO> getAllByChuDe(Integer idChuDe);
}
