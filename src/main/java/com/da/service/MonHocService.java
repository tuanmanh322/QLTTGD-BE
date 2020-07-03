package com.da.service;

import com.da.dto.MonHocDTO;
import com.da.dto.MonHocSearchDTO;
import com.da.model.Monhoc;

import java.util.List;

public interface MonHocService {
    List<Monhoc> getAll();

    void searchMH(MonHocSearchDTO dto);

    void add(MonHocDTO monHocDTO);

    void edit(MonHocDTO monHocDTO);

    void delete(Integer idMH);

    boolean checkExistName(String tenMh);

    boolean checkExítMaMH(String maMh);
}
