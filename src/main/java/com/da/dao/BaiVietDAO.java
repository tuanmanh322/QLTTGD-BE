package com.da.dao;

import com.da.dto.BaiVietSearchDTO;
import com.da.dto.BaiVietTotalSearchDTO;

import java.io.Serializable;

public interface BaiVietDAO extends Serializable,BaseDAO{

    void searchBaiViet(BaiVietSearchDTO dto);

    void searchBaiVietToTal(BaiVietTotalSearchDTO searchDTO);
}
