package com.da.dao;

import com.da.dto.ChuDeCountDTO;
import com.da.dto.ChuDeSearchDTO;

import java.io.Serializable;
import java.util.List;

public interface ChuDeDAO extends Serializable,BaseDAO{
    void searchChuDe(ChuDeSearchDTO dto);

    List<ChuDeCountDTO> getChuAndCount(Integer idHm);
}
