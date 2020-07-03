package com.da.service.impl;

import com.da.dao.MonHocDAO;
import com.da.dto.MonHocDTO;
import com.da.dto.MonHocSearchDTO;
import com.da.model.Monhoc;
import com.da.repository.MonhocRepository;
import com.da.service.MonHocService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MonHocServiceImpl implements MonHocService {
    private final Logger log = LoggerFactory.getLogger(MonHocServiceImpl.class);

    private final ModelMapper modelMapper;

    private final MonhocRepository monhocRepository;

    private final MonHocDAO  monHocDAO;

    public MonHocServiceImpl(ModelMapper modelMapper, MonhocRepository monhocRepository, MonHocDAO monHocDAO) {
        this.modelMapper = modelMapper;
        this.monhocRepository = monhocRepository;
        this.monHocDAO = monHocDAO;
    }

    @Override
    public List<Monhoc> getAll() {
        return monhocRepository.findAll();
    }

    @Override
    public void searchMH(MonHocSearchDTO dto) {
        monHocDAO.searchMH(dto);
    }

    @Override
    public void add(MonHocDTO monHocDTO) {
        Monhoc monhoc = modelMapper.map(monHocDTO,Monhoc.class);
        monhocRepository.save(monhoc);
     }

    @Override
    public void edit(MonHocDTO monHocDTO) {
        Monhoc monhoc = monhocRepository.findById(monHocDTO.getId()).get();
        monhoc.setMaMonhoc(monHocDTO.getMaMonhoc());
        monhoc.setTenmonhoc(monHocDTO.getTenmonhoc());
        monhocRepository.save(monhoc);
    }

    @Override
    public void delete(Integer idMH) {
        Monhoc monhoc = monhocRepository.getOne(idMH);
        monhocRepository.delete(monhoc);
    }

    @Override
    public boolean checkExistName(String tenMh) {
        Optional<Monhoc> monhoc = monhocRepository.findByTenmonhoc("%" + tenMh.trim() + "%");
        if (monhoc.isPresent()) {
            return  true;
        }
        return false;
    }

    @Override
    public boolean checkExítMaMH(String maMh) {
        Optional<Monhoc> monhoc = monhocRepository.findByMaMH("%" + maMh.trim() + "%");
        if (monhoc.isPresent()) {
            return  true;
        }
        return false;
    }
}
