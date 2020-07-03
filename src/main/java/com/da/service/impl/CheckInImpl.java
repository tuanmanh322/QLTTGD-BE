package com.da.service.impl;

import com.da.dao.CheckInDAO;
import com.da.dto.CheckInDTO;
import com.da.dto.CheckInDetailDTO;
import com.da.exception.ResultException;
import com.da.model.Nhatcheckin;
import com.da.model.The;
import com.da.model.Users;
import com.da.repository.NhatcheckinRepository;
import com.da.repository.TheRepository;
import com.da.repository.UsersRepository;
import com.da.security.SecurityUtils;
import com.da.service.CheckInService;
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
public class CheckInImpl implements CheckInService {
    private final Logger log = LoggerFactory.getLogger(CheckInImpl.class);

    private final ModelMapper modelMap;
    private final CheckInDAO checkInDAO;

    private final NhatcheckinRepository nhatcheckinRepository;

    private final TheRepository theRepository;

    private final UsersRepository usersRepository;

    public CheckInImpl(ModelMapper modelMap, CheckInDAO checkInDAO, NhatcheckinRepository nhatcheckinRepository, TheRepository theRepository, UsersRepository usersRepository) {
        this.modelMap = modelMap;
        this.checkInDAO = checkInDAO;
        this.nhatcheckinRepository = nhatcheckinRepository;
        this.theRepository = theRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public void searchCheckIn(CheckInDTO dto) {
        log.info(" start service to checkIn with :{}",dto);
        checkInDAO.searchCheckIn(dto);
    }

    @Override
    public void add(CheckInDTO dto) throws ResultException {
        log.info(" start service to addLopHoc with :{}",dto);
        Users user = modelMap.map(dto, Users.class);
        checkInDAO.save(user);
    }

    @Override
    public void searchCheckInByProfile(CheckInDTO dto) {
        log.info(" start service to searchCheckInByProfile with :{}",dto);
        checkInDAO.searchCheckInByProfile(dto, SecurityUtils.getCurrentUserIdLogin());
    }

    @Override
    public CheckInDetailDTO getCheckinByIdThe(Integer idThe) {
        CheckInDetailDTO checkDTO = new CheckInDetailDTO();
        checkDTO.setNhatcheckins(nhatcheckinRepository.getListByIDtHE(idThe));
        The the = theRepository.getOne(idThe);
        checkDTO.setMaThe(the.getMaThe());
        checkDTO.setIdRole(the.getIdRole());
        Users users = usersRepository.findByMaThe(the.getId());
        checkDTO.setUserName(users.getName());
        return checkDTO;
    }


}
