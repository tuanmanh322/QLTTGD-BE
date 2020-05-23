package com.da.service.impl;

import com.da.dao.CheckInDAO;
import com.da.dto.CheckInDTO;

import com.da.exception.ResultException;
import com.da.model.Users;
import com.da.service.CheckInService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CheckInImpl implements CheckInService {
    private final Logger log = LoggerFactory.getLogger(CheckInImpl.class);

    private final ModelMapper modelMap;
    private final CheckInDAO checkInDAO;

    public CheckInImpl(ModelMapper modelMap, CheckInDAO checkInDAO) {
        this.modelMap = modelMap;
        this.checkInDAO = checkInDAO;
    }
    @Override
    public void searchCheckIn(CheckInDTO dto) {
        log.info(" start service to checkIn with :{}",dto);
        checkInDAO.searchCheckIn(dto);
    }

    @Override
    public void add(CheckInDTO dto) throws ResultException {
        log.info(" start service to addLopHoc with :{}",dto);
        Users user = modelMap.map(dto, Users.class);
        checkInDAO.save(user);
    }
}
