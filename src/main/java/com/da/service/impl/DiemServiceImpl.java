package com.da.service.impl;

import com.da.common.ParseDiemTB;
import com.da.dao.DiemDAO;
import com.da.dto.*;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.*;
import com.da.repository.LopRepository;
import com.da.repository.UserLopMapperRepository;
import com.da.repository.UsersDiemMapRepository;
import com.da.repository.UsersRepository;
import com.da.security.SecurityUtils;
import com.da.service.DiemService;
import com.da.service.HocSinhService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DiemServiceImpl implements DiemService {
    private final Logger log = LoggerFactory.getLogger(HocSinhService.class);


    private final ModelMapper modelMap;

    private final DiemDAO diemDAO;

    private final UsersRepository usersRepository;

    private final LopRepository lopRepository;

    private final UsersDiemMapRepository usersDiemMapRepository;

    private final UserLopMapperRepository userLopMapperRepository;

    public DiemServiceImpl(ModelMapper modelMap, DiemDAO diemDAO, UsersRepository usersRepository, LopRepository lopRepository, UsersDiemMapRepository usersDiemMapRepository, UserLopMapperRepository userLopMapperRepository) {
        this.modelMap = modelMap;
        this.diemDAO = diemDAO;
        this.usersRepository = usersRepository;
        this.lopRepository = lopRepository;
        this.usersDiemMapRepository = usersDiemMapRepository;
        this.userLopMapperRepository = userLopMapperRepository;
    }

    @Override
    public void searchDiem(DiemDTO dto) {
        log.info(" start service to searchDiem with :{}", dto);
        diemDAO.searchDiem(dto);
    }

    @Override
    public void add(DiemActionDTO dto) throws ResultException {
        log.info(" start service to addDiem with :{}", dto);
        Diem diem = new Diem();
        UsersDiemMap diemMap = new UsersDiemMap();
        Optional<Users> users = usersRepository.findById(dto.getIdUser());
        if (users.isPresent()) {
            Users us = users.get();
            diemMap.setIdUser(us.getId());
            us.setMaLop(dto.getMaLop());
            usersRepository.save(us);
            UserLopMapper userLopMapper = new UserLopMapper();
            userLopMapper.setIdLop(dto.getMaLop());
            userLopMapper.setIdUser(us.getId());
            userLopMapperRepository.save(userLopMapper);
        }
        diem.setDiem15p(dto.getDiem15p());
        diem.setDiemmieng(dto.getDiemmieng());
        diem.setDiem90p(dto.getDiem90p());
        diem.setDiemtb(ParseDiemTB.diemTB(dto.getDiemmieng(), dto.getDiem15p(), dto.getDiem90p()));
        diemDAO.save(diem);
        diemMap.setIdDiem(diem.getId());
        usersDiemMapRepository.save(diemMap);
    }

    @Override
    public void update(DiemActionDTO dto) throws ResultException {
        log.info(" start service to editLopHoc with :{}", dto);
        Diem diem = diemDAO.findById(dto.getId(), Diem.class).get();
        if (diem.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        Optional<Users> users = usersRepository.findById(dto.getIdUser());
        if (users.isPresent()) {
            Users u = users.get();
            Lop lop = lopRepository.getOne(dto.getMaLop());
            lop.setKipDay(dto.getKipDay());
            lopRepository.save(lop);
            UserLopMapper userLopMapper = userLopMapperRepository.findByUserAndLop(u.getId(),dto.getIdLopOld());
            userLopMapper.setIdLop(lop.getId());
            userLopMapperRepository.save(userLopMapper);
        }
        diem.setDiem15p(dto.getDiem15p());
        diem.setDiemmieng(dto.getDiemmieng());
        diem.setDiem90p(dto.getDiem90p());
        diem.setDiemtb(ParseDiemTB.diemTB(dto.getDiemmieng(), dto.getDiem15p(), dto.getDiem90p()));
        diemDAO.update(diem);
    }

    @Override
    public void delete(Integer id) throws ResultException {
        log.info(" start service to delete Lop with id:{}", id);
        Diem diem = diemDAO.findById(id, Diem.class).get();
        if (diem.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        UsersDiemMap diemMap = usersDiemMapRepository.findWithIdDiem(id);
        usersDiemMapRepository.delete(diemMap);
        diemDAO.delete(diem);
    }

    @Override
    public DiemDTO findById(Integer id) {
        Diem diem = diemDAO.findById(id, Diem.class).get();
        DiemDTO dto = modelMap.map(diem, DiemDTO.class);
        return dto;
    }

    @Override
    public void searchDiemByProfile(DiemSearchDTO dto) {
        log.info(" start service to searchDiemByProfile with :{}", dto);
        diemDAO.searchDiemProfile(dto, SecurityUtils.getCurrentUserIdLogin());
    }

    @Override
    public List<DiemToExcelDTO> getAllByIdUser(Integer ud) {
        log.info(" start service to getAllByIdUser");
        return  diemDAO.getAllByIdThe(ud);
    }
}
