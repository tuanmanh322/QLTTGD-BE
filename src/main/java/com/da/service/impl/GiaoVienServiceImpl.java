package com.da.service.impl;

import com.da.dao.GiaoVienDAO;
import com.da.dto.GiaoVienDTO;
import com.da.dto.HocSinhDTO;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.Users;
import com.da.service.GiaoVienService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GiaoVienServiceImpl implements GiaoVienService {
    private final Logger log = LoggerFactory.getLogger(GiaoVienServiceImpl.class);

    private final ModelMapper modelMap;

    private final GiaoVienDAO giaoVienDAO;

    public GiaoVienServiceImpl(ModelMapper modelMap, GiaoVienDAO giaoVienDAO) {
        this.modelMap = modelMap;
        this.giaoVienDAO = giaoVienDAO;
    }
    @Override
    public void searchGiaoVien(GiaoVienDTO dto) {
        log.info(" start service to searchLopHoc with :{}",dto);
        giaoVienDAO.searchGiaoVien(dto);
    }

    @Override
    public void add(GiaoVienDTO dto) throws ResultException {
        log.info(" start service to addLopHoc with :{}",dto);
        Users user = modelMap.map(dto, Users.class);
        giaoVienDAO.save(user);
    }

    @Override
    public void update(GiaoVienDTO dto) throws ResultException {
        log.info(" start service to editLopHoc with :{}",dto);
        Users user = giaoVienDAO.findById(dto.getId(), Users.class).get();
        if (user.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        user = modelMap.map(dto, Users.class);
        giaoVienDAO.update(user);
    }

    @Override
    public void delete(Integer id) throws ResultException {
        log.info(" start service to delete Lop with id:{}",id);
        Users user = giaoVienDAO.findById(id, Users.class).get();
        if (user.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        giaoVienDAO.delete(user);
    }

    @Override
    public GiaoVienDTO findById(Integer id) {
        Users user = giaoVienDAO.findById(id, Users.class).get();
        GiaoVienDTO dto = modelMap.map(user, GiaoVienDTO.class);
        return dto;
    }
}
