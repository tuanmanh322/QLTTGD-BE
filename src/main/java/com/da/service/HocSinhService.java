package com.da.service;

import com.da.common.CommonResult;
import com.da.dto.HocSinhDTO;
import com.da.exception.ResultException;

public interface HocSinhService {
    void searchHocSinh(HocSinhDTO dto);
    CommonResult add(HocSinhDTO dto) throws ResultException;
    void update(HocSinhDTO dto)throws ResultException;
    void delete(Integer id)throws ResultException;
    HocSinhDTO findById(Integer id);

    Integer countAllHS();

    Integer countHSActive();

    CommonResult registerLop(Integer idLop);

    void activeLop(Integer id);

    void unActiveLop(Integer id);

    void deleteULM(Integer idULM);
}
