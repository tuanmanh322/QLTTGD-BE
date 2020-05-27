package com.da.service.impl;

import com.da.dao.HocSinhDao;
import com.da.dto.HocSinhDTO;
import com.da.dto.LopHocDTO;
import com.da.dto.LopHocSearchDTO;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.Lop;
import com.da.model.Users;
import com.da.service.HocSinhService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class HocSinhServiceImpl implements HocSinhService {
    private final Logger log = LoggerFactory.getLogger(HocSinhService.class);


    private final ModelMapper modelMap;

    private final HocSinhDao hocSinhDao;

    public HocSinhServiceImpl(ModelMapper modelMap, HocSinhDao lopHocDao) {
        this.modelMap = modelMap;
        this.hocSinhDao = lopHocDao;
    }
    @Override
    public void searchHocSinh(HocSinhDTO dto) {
        log.info(" start service to searchLopHoc with :{}",dto);
        hocSinhDao.searchHocSinh(dto);
    }

    @Override
    public void add(HocSinhDTO dto) throws ResultException {
        log.info(" start service to addLopHoc with :{}",dto);
        Users user = modelMap.map(dto, Users.class);
        hocSinhDao.save(user);
    }

    @Override
    public void update(HocSinhDTO dto) throws ResultException {
        log.info(" start service to editLopHoc with :{}",dto);
        Users user = hocSinhDao.findById(dto.getId(), Users.class).get();
        if (user.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        user = modelMap.map(dto, Users.class);
        hocSinhDao.update(user);
    }

    @Override
    public void delete(Integer id) throws ResultException {
        log.info(" start service to delete Lop with id:{}",id);
        Users user = hocSinhDao.findById(id, Users.class).get();
        if (user.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        hocSinhDao.delete(user);
    }

    @Override
    public HocSinhDTO findById(Integer id) {
        Users user = hocSinhDao.findById(id, Users.class).get();
        HocSinhDTO dto = modelMap.map(user, HocSinhDTO.class);
        return dto;
    }
}
