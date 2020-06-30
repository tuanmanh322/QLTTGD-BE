package com.da.service.impl;

import com.da.dao.NhatKyCheckInDAO;
import com.da.dto.NhatKySearchDTO;
import com.da.repository.NhatcheckinRepository;
import com.da.service.NhatKyCheckInService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NhatKyCheckinServiceImpl implements NhatKyCheckInService {

    private final NhatKyCheckInDAO nhatKyCheckInDAO;

    private final ModelMapper modelMapper;

    private final NhatcheckinRepository nhatcheckinRepository;

    public NhatKyCheckinServiceImpl(NhatKyCheckInDAO nhatKyCheckInDAO, ModelMapper modelMapper, NhatcheckinRepository nhatcheckinRepository) {
        this.nhatKyCheckInDAO = nhatKyCheckInDAO;
        this.modelMapper = modelMapper;
        this.nhatcheckinRepository = nhatcheckinRepository;
    }

    @Override
    public void searchNkAdmin(NhatKySearchDTO nhatKySearchDTO) {
        nhatKyCheckInDAO.searchNk(nhatKySearchDTO);
    }
}
