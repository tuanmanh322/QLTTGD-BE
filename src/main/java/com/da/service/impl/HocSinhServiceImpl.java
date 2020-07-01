package com.da.service.impl;

import com.da.common.CommonResult;
import com.da.dao.HocSinhDao;
import com.da.dto.HocSinhDTO;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.The;
import com.da.model.UserLopMapper;
import com.da.model.Users;
import com.da.repository.TheRepository;
import com.da.repository.UserLopMapperRepository;
import com.da.repository.UsersRepository;
import com.da.security.SecurityUtils;
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
public class HocSinhServiceImpl implements HocSinhService {
    private final Logger log = LoggerFactory.getLogger(HocSinhService.class);


    private final ModelMapper modelMap;

    private final HocSinhDao hocSinhDao;

    private final TheRepository theRepository;

    private final UserLopMapperRepository userLopMapperRepository;

    private final UsersRepository usersRepository;

    public HocSinhServiceImpl(ModelMapper modelMap, HocSinhDao hocSinhDao, TheRepository theRepository, UserLopMapperRepository userLopMapperRepository, UsersRepository usersRepository) {
        this.modelMap = modelMap;
        this.hocSinhDao = hocSinhDao;
        this.theRepository = theRepository;
        this.userLopMapperRepository = userLopMapperRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public void searchHocSinh(HocSinhDTO dto) {
        log.info(" start service to searchLopHoc with :{}", dto);
        hocSinhDao.searchHocSinh(dto);
    }

    @Override
    public void add(HocSinhDTO dto) throws ResultException {
        log.info(" start service to addLopHoc with :{}", dto);
        Users user = modelMap.map(dto, Users.class);
        hocSinhDao.save(user);
    }

    @Override
    public void update(HocSinhDTO dto) throws ResultException {
        log.info(" start service to editLopHoc with :{}", dto);
        Users user = hocSinhDao.findById(dto.getId(), Users.class).get();
        if (user.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        user = modelMap.map(dto, Users.class);
        hocSinhDao.update(user);
    }

    @Override
    public void delete(Integer id) throws ResultException {
        log.info(" start service to delete Lop with id:{}", id);
        Users user = hocSinhDao.findById(id, Users.class).get();
        if (user.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        hocSinhDao.delete(user);
    }

    @Override
    public HocSinhDTO findById(Integer id) {
        Users user = hocSinhDao.findById(id, Users.class).get();
        HocSinhDTO dto = modelMap.map(user, HocSinhDTO.class);
        return dto;
    }

    @Override
    public Integer countAllHS() {
        List<The> theList = theRepository.getListAllHocSInh();
        return theList.size();
    }

    @Override
    public Integer countHSActive() {
        List<The> theList = theRepository.getListHocSInhActive();
        return theList.size();
    }

    @Override
    public CommonResult registerLop(Integer idLop) {
        Users users = usersRepository.findByMaThe(SecurityUtils.getCurrentUserIdLogin());
        Optional<UserLopMapper> ulm = userLopMapperRepository.checkUserAndLop(users.getId(), idLop);
        if (ulm.isPresent()) {
            return CommonResult.failed("Bạn đã đăng ký lớp này rồi");
        }
        UserLopMapper userLopMapper = new UserLopMapper();
        userLopMapper.setIdLop(idLop);
        userLopMapper.setIdUser(users.getId());
        userLopMapper.setActive(false);
        userLopMapperRepository.save(userLopMapper);
        return CommonResult.success(userLopMapper);
    }

    @Override
    public void activeLop(Integer id) {
        UserLopMapper userLopMapper = userLopMapperRepository.getOne(id);
        userLopMapper.setActive(true);
        userLopMapperRepository.save(userLopMapper);
    }

    @Override
    public void unActiveLop(Integer id) {
        UserLopMapper userLopMapper = userLopMapperRepository.getOne(id);
        userLopMapper.setActive(false);
        userLopMapperRepository.save(userLopMapper);
    }

    @Override
    public void deleteULM(Integer idULM) {
        UserLopMapper userLopMapper = userLopMapperRepository.getOne(idULM);
        userLopMapperRepository.delete(userLopMapper);
    }
}
