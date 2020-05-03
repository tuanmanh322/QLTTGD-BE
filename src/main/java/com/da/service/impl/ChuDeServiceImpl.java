package com.da.service.impl;
import com.da.dto.ChuDeDTO;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.Chude;
import com.da.service.ChuDeService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.da.dao.ChuDeDAO;
import com.da.dto.ChuDeSearchDTO;

import java.util.Date;


@Service
@Transactional
public class ChuDeServiceImpl implements ChuDeService {
    private final Logger log = LoggerFactory.getLogger(ChuDeServiceImpl.class);

    private final ModelMapper modelMap;

    private final ChuDeDAO chuDeDao;

    public ChuDeServiceImpl(ModelMapper modelMap, ChuDeDAO chuDeDao) {
        super();
        this.modelMap = modelMap;
        this.chuDeDao = chuDeDao;
    }
    @Override
    public void searchChuDe(ChuDeSearchDTO dto) {
        log.info(" start service to searchChuDe with :{}",dto);
        chuDeDao.searchChuDe(dto);
    }

    @Override
    public ChuDeDTO findById(Integer id) {
        Chude cd = chuDeDao.findById(id, Chude.class).get();
        ChuDeDTO dto = modelMap.map(cd, ChuDeDTO.class);
        return dto;
    }
    @Override
    public void add(ChuDeDTO dto) throws ResultException {
        log.info(" start service to searchChuDe with :{}",dto);
        Chude chude = modelMap.map(dto, Chude.class);
        chuDeDao.save(chude);
    }
    @Override
    public void update(ChuDeDTO dto) throws ResultException {
        log.info(" start service to update with :{}",dto);
        Chude chude = chuDeDao.findById(dto.getId(), Chude.class).get();
        if (chude.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        chude = modelMap.map(dto, Chude.class);
        chuDeDao.update(chude);
    }
    @Override
    public void delete(Integer id) throws ResultException {
        log.info(" start service to delete with :{}",id);
        Chude chude = chuDeDao.findById(id, Chude.class).get();
        if (chude.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        chuDeDao.delete(chude);
    }
}

