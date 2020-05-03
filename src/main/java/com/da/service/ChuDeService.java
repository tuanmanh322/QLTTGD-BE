package com.da.service;

import com.da.dto.ChuDeDTO;
import com.da.dto.ChuDeSearchDTO;


public interface ChuDeService {
    void searchChuDe(ChuDeSearchDTO dto);

  ChuDeDTO findById(Integer id);

}
