package com.da.service.impl;

import com.da.dao.BaiVietDAO;
import com.da.dto.BaiVietDTO;
import com.da.dto.BaiVietSearchDTO;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.Baiviet;
import com.da.security.SecurityUtils;
import com.da.service.BaiVietService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BaiVietServiceImpl implements BaiVietService {
    private final Logger log = LoggerFactory.getLogger(ChuDeServiceImpl.class);

    private final ModelMapper modelMap;

    private final BaiVietDAO baiVietDao;

    public BaiVietServiceImpl(ModelMapper modelMap, BaiVietDAO baiVietDao) {
        super();
        this.modelMap = modelMap;
        this.baiVietDao = baiVietDao;
    }

    @Override
    public void searchBaiViet(BaiVietSearchDTO dto) {
        log.info(" start service to searchChuDe with :{}",dto);
        baiVietDao.searchBaiViet(dto);
    }

    @Override
    public void add(BaiVietDTO dto) throws ResultException {
        log.info(" start service to searchChuDe with :{}",dto);
        Baiviet baiviet = modelMap.map(dto, Baiviet.class);
        baiviet.setIdUser(SecurityUtils.getCurrentUserIdLogin());
        baiVietDao.save(dto);

    }

    @Override
    public void update(BaiVietDTO dto) throws ResultException {
        log.info(" start service to update with :{}",dto);
        Baiviet baiviet = baiVietDao.findById(dto.getId(),Baiviet.class).get();
        if (baiviet.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        baiviet = modelMap.map(dto, Baiviet.class);
        baiVietDao.update(baiviet);
    }

    @Override
    public void delete(Integer id) throws ResultException {
        log.info(" start service to update with :{}",id);
        Baiviet baiviet = baiVietDao.findById(id, Baiviet.class).get();
        if (baiviet.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        baiVietDao.delete(baiviet);
    }

    @Override
    public BaiVietDTO findById(Integer id)
    {
        Baiviet baiviet = baiVietDao.findById(id, Baiviet.class).get();
        BaiVietDTO dto = modelMap.map(baiviet, BaiVietDTO.class);
        return dto;
    }
}
