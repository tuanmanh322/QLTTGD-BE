package com.da.service.impl;

import com.da.dao.DiemDAO;
import com.da.dto.DiemDTO;
import com.da.dto.HocSinhDTO;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.Diem;
import com.da.model.Users;
import com.da.service.DiemService;
import com.da.service.HocSinhService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DiemServiceImpl implements DiemService {
    private final Logger log = LoggerFactory.getLogger(HocSinhService.class);


    private final ModelMapper modelMap;

    private final DiemDAO diemDAO;

    public DiemServiceImpl(ModelMapper modelMap, DiemDAO diemDAO) {
        this.modelMap = modelMap;
        this.diemDAO = diemDAO;
    }
    @Override
    public void searchDiem(DiemDTO dto) {
        log.info(" start service to searchLopHoc with :{}",dto);
        diemDAO.searchDiem(dto);
    }

    @Override
    public void add(DiemDTO dto) throws ResultException {
        log.info(" start service to addLopHoc with :{}",dto);
        Diem diem = modelMap.map(dto, Diem.class);
        diemDAO.save(diem);
    }

    @Override
    public void update(DiemDTO dto) throws ResultException {
        log.info(" start service to editLopHoc with :{}",dto);
        Diem diem = diemDAO.findById(dto.getId(), Diem.class).get();
        if (diem.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        diem = modelMap.map(dto, Diem.class);
        diemDAO.update(diem);
    }

    @Override
    public void delete(Integer id) throws ResultException {
        log.info(" start service to delete Lop with id:{}",id);
        Diem diem = diemDAO.findById(id, Diem.class).get();
        if (diem.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        diemDAO.delete(diem);
    }

    @Override
    public DiemDTO findById(Integer id) {
        Diem diem = diemDAO.findById(id, Diem.class).get();
        DiemDTO dto = modelMap.map(diem, DiemDTO.class);
        return dto;
    }
}
