package com.da.dao;

import com.da.dto.BaiVietSearchDTO;

import java.io.Serializable;

public interface BaiVietDAO extends Serializable,BaseDAO{

    void searchBaiViet(BaiVietSearchDTO dto);
}
