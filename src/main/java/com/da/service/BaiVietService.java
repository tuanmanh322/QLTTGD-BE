package com.da.service;

import com.da.dto.BaiVietDTO;
import com.da.dto.BaiVietSearchDTO;
import com.da.dto.BaiVietTotalSearchDTO;
import com.da.dto.CommentDTO;
import com.da.exception.ResultException;
import com.da.model.Baiviet;

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

    void searchBaiVietGetTotal(BaiVietTotalSearchDTO baiVietTotalSearchDTO);

    void searchBaiVietGetTotalByIdCD(BaiVietTotalSearchDTO baiVietTotalSearchDTO, Integer idCD);

    boolean isLikeOrUnLikeBV(Integer idBV, BaiVietDTO baiVietDTO);

    boolean isDislikeOrUnDisLikeBV(Integer idBV, BaiVietDTO baiVietDTO);

    Baiviet findByIdModel(Integer idBV);
}
