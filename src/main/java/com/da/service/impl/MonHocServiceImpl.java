package com.da.service.impl;

import com.da.model.Monhoc;
import com.da.repository.MonhocRepository;
import com.da.service.MonHocService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MonHocServiceImpl implements MonHocService {
    private final Logger log = LoggerFactory.getLogger(MonHocServiceImpl.class);

    private final ModelMapper modelMapper;

    private final MonhocRepository monhocRepository;

    public MonHocServiceImpl(ModelMapper modelMapper, MonhocRepository monhocRepository) {
        this.modelMapper = modelMapper;
        this.monhocRepository = monhocRepository;
    }

    @Override
    public List<Monhoc> getAll() {
        return monhocRepository.findAll();
    }
}
