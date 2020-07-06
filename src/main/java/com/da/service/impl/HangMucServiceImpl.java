package com.da.service.impl;

import com.da.dao.HangMucDAO;
import com.da.dto.HangMucCDDTO;
import com.da.dto.HangMucDTO;
import com.da.dto.HangMucSearchDTO;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.Hangmuc;
import com.da.repository.ChudeRepository;
import com.da.repository.HangMucRepository;
import com.da.service.HangMucService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class
HangMucServiceImpl implements HangMucService {
    private final Logger log = LoggerFactory.getLogger(HangMucServiceImpl.class);

    private final ModelMapper modelMap;

    private final HangMucDAO hangMucDao;

    private final ChudeRepository chudeRepository;

    private final HangMucRepository hangMucRepository;

    public HangMucServiceImpl(ModelMapper modelMap, HangMucDAO hangMucDao, ChudeRepository chudeRepository, HangMucRepository hangMucRepository) {
        this.modelMap = modelMap;
        this.hangMucDao = hangMucDao;
        this.chudeRepository = chudeRepository;
        this.hangMucRepository = hangMucRepository;
    }

    @Override
    public void searchHangMuc(HangMucSearchDTO dto) {
        log.info(" start service to searchHangMuc with :{}", dto);
        hangMucDao.searchHangMuc(dto);
    }

    @Override
    public void add(HangMucDTO dto) throws ResultException {
        log.info(" start service to searchChuDe with :{}", dto);
        Hangmuc hangmuc = modelMap.map(dto, Hangmuc.class);
        hangMucDao.save(hangmuc);
    }

    @Override
    public void update(HangMucDTO dto) throws ResultException {
        log.info(" start service to update with :{}", dto);
        Hangmuc hangmuc = hangMucDao.findById(dto.getId(), Hangmuc.class).get();
        if (hangmuc.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        hangmuc = modelMap.map(dto, Hangmuc.class);
        hangMucDao.update(hangmuc);
    }

    @Override
    public void delete(Integer id) throws ResultException {
        log.info(" start service to delete with :{}", id);
        Hangmuc hangmuc = hangMucDao.findById(id, Hangmuc.class).get();
        if (hangmuc.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        hangMucDao.delete(hangmuc);
    }

    @Override
    public HangMucDTO findById(Integer id) {
        Hangmuc hm = hangMucDao.findById(id, Hangmuc.class).get();
        HangMucDTO dto = modelMap.map(hm, HangMucDTO.class);
        return dto;
    }

    @Override
    public List<HangMucCDDTO> getListHMwithCD() {
        List<HangMucCDDTO> hangMucCDDTOS = new ArrayList<>();
        List<Hangmuc> hmList = hangMucRepository.findAll();
        hmList.stream().map(hm -> {
            HangMucCDDTO cddto = new HangMucCDDTO();
//            cddto.set
            return hm;
        }).collect(Collectors.toList());
        return null;
    }
}
