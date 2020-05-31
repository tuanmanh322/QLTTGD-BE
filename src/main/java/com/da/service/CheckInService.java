package com.da.service;

import com.da.dto.CheckInDTO;
import com.da.dto.HocSinhDTO;
import com.da.exception.ResultException;

public interface CheckInService {
    void searchCheckIn(CheckInDTO dto);
    void add(CheckInDTO dto) throws ResultException;
}