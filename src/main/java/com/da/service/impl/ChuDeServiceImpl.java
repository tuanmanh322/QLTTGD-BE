package com.da.service.impl;
import com.da.dto.ChuDeDTO;
import com.da.model.Chude;
import com.da.service.ChuDeService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.da.dao.ChuDeDAO;
import com.da.dto.ChuDeSearchDTO;


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
}