package com.da.service.impl;

import com.da.dto.LopHocRequestDTO;
import com.da.model.Monhoc;
import com.da.model.The;
import com.da.repository.LopRepository;
import com.da.repository.MonhocRepository;
import com.da.repository.TheRepository;
import com.da.security.SecurityUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.da.dao.LopHocDAO;
import com.da.dto.LopHocDTO;
import com.da.dto.LopHocSearchDTO;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.Lop;
import com.da.service.LopHocService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LopHocServiceImpl implements LopHocService {
    private final Logger log = LoggerFactory.getLogger(LopHocServiceImpl.class);

    private final ModelMapper modelMap;

    private final LopHocDAO lopHocDao;

    private final MonhocRepository monhocRepository;

    private final LopRepository lopRepository;

    private final TheRepository theRepository;


    public LopHocServiceImpl(ModelMapper modelMap, LopHocDAO lopHocDao, MonhocRepository monhocRepository, LopRepository lopRepository, TheRepository theRepository) {
        this.modelMap = modelMap;
        this.lopHocDao = lopHocDao;
        this.monhocRepository = monhocRepository;
        this.lopRepository = lopRepository;
        this.theRepository = theRepository;
    }

    @Override
    public void searchLopHoc(LopHocSearchDTO dto) {
        log.info(" start service to searchLopHoc with :{}", dto);
        lopHocDao.searchLopHoc(dto);
    }

    @Override
    public void add(LopHocDTO dto) throws ResultException {
        log.info(" start service to addLopHoc with :{}", dto);
        Lop lop = modelMap.map(dto, Lop.class);
        Optional<Monhoc> monhoc = monhocRepository.findById(dto.getMaMonhoc());
        if (!monhoc.isPresent()) {
            throw new ResultException(ErrorCode.RECORD_NOT_FOUND);
        }
        lop.setMaMonhoc(monhoc.get().getId());
        lopHocDao.save(lop);
    }

    @Override
    public void update(LopHocDTO dto) throws ResultException {
        log.info(" start service to editLopHoc with :{}", dto);
        Lop lop = lopHocDao.findById(dto.getId(), Lop.class).get();
        if (lop.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        Lop check = lopRepository.findByTenlop(dto.getTenlop());
        if (check.getId() != null) {
            throw new ResultException(ErrorCode.RECORD_EXISTED);
        }
        lop = modelMap.map(dto, Lop.class);
        lopHocDao.update(lop);
    }

    @Override
    public void delete(Integer id) throws ResultException {
        log.info(" start service to delete Lop with id:{}", id);
        Lop lop = lopHocDao.findById(id, Lop.class).get();
        if (lop.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        lopHocDao.delete(lop);
    }

    @Override
    public LopHocDTO findById(Integer id) {
        Lop lop = lopHocDao.findById(id, Lop.class).get();
        LopHocDTO dto = modelMap.map(lop, LopHocDTO.class);
        return dto;
    }

    @Override
    public void getListLopHocByIdThe(LopHocSearchDTO dto) {
        log.info(" start service to getListLopHocByIdThe");
        lopHocDao.getListLopHocByIdThe(dto, SecurityUtils.getCurrentUserIdLogin());
    }

    @Override
    public void getListHocBaByIdThe(LopHocSearchDTO dto) {
        log.info(" start service to getListHocBaByIdThe");
        lopHocDao.getListHocBaByIdThe(dto, SecurityUtils.getCurrentUserIdLogin());
    }

    @Override
    public void searchLopHocFilter(LopHocSearchDTO dto) {
        log.info(" start service to searchLopHocFilter with :{}", dto);
        lopHocDao.searchLopHocFilter(dto);
    }

    @Override
    public List<Lop> getLopUnExpired() {
        return lopRepository.getAllUnExpired();
    }

    @Override
    public List<LopHocDTO> getLopByMaThe(String maThe) {
        log.info(" start service to getLopByMaThe with :{}", maThe);
        return lopHocDao.getLopByMaThe(maThe);
    }

    @Override
    public void getListLopRequest(LopHocRequestDTO lopHocRequestDTO) {
        lopHocDao.getListLopRequest(lopHocRequestDTO);
    }

}
