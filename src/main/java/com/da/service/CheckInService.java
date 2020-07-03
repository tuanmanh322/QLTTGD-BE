package com.da.service;

import com.da.dto.CheckInDTO;
import com.da.dto.CheckInDetailDTO;
import com.da.dto.HocSinhDTO;
import com.da.dto.NhatKySearchDTO;
import com.da.exception.ResultException;

import java.util.List;

public interface CheckInService {
    void searchCheckIn(CheckInDTO dto);
    void add(CheckInDTO dto) throws ResultException;

    void searchCheckInByProfile(CheckInDTO dto);

    CheckInDetailDTO getCheckinByIdThe(Integer idThe);
}
