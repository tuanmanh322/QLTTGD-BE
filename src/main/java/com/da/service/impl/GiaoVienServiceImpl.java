package com.da.service.impl;

import com.da.common.CommonResult;
import com.da.common.Constant;
import com.da.common.RandomString;
import com.da.dao.GiaoVienDAO;
import com.da.dto.CardDTO;
import com.da.dto.GiaoVienDTO;
import com.da.dto.HocSinhDTO;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.*;
import com.da.repository.*;
import com.da.security.UserTypeEnum;
import com.da.service.GiaoVienService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GiaoVienServiceImpl implements GiaoVienService {
    private final Logger log = LoggerFactory.getLogger(GiaoVienServiceImpl.class);

    private final ModelMapper modelMap;

    private final GiaoVienDAO giaoVienDAO;

    private final PasswordEncoder passwordEncoder;

    private final TheRepository theRepository;

    private final UserLopMapperRepository userLopMapperRepository;

    private final UsersRepository usersRepository;

    private final BaivietRepository baivietRepository;

    private final CommentRepository commentRepository;

    private final RepcommentRepository repcommentRepository;


    public GiaoVienServiceImpl(ModelMapper modelMap, GiaoVienDAO giaoVienDAO, PasswordEncoder passwordEncoder, TheRepository theRepository, UserLopMapperRepository userLopMapperRepository, UsersRepository usersRepository, BaivietRepository baivietRepository, CommentRepository commentRepository, RepcommentRepository repcommentRepository) {
        this.modelMap = modelMap;
        this.giaoVienDAO = giaoVienDAO;
        this.passwordEncoder = passwordEncoder;
        this.theRepository = theRepository;
        this.userLopMapperRepository = userLopMapperRepository;
        this.usersRepository = usersRepository;
        this.baivietRepository = baivietRepository;
        this.commentRepository = commentRepository;
        this.repcommentRepository = repcommentRepository;
    }

    @Override
    public void searchGiaoVien(GiaoVienDTO dto) {
        log.info(" start service to searchLopHoc with :{}", dto);
        giaoVienDAO.searchGiaoVien(dto);
    }

    @Override
    public CommonResult add(GiaoVienDTO dto) throws ResultException {
        log.info(" start service to addLopHoc with :{}", dto);
        The the = new The();
        String maThe = RandomString.rdMaThe("1212");
        Optional<The> t = theRepository.findByMaThe(maThe);
        if (!t.isPresent()) {
            the.setMaThe(maThe);
            the.setPassword(passwordEncoder.encode("123456"));
            the.setNgaycap(new Date());
            the.setIdRole(UserTypeEnum.TEACHER.getId());
            the.setTrangthai(Boolean.TRUE);
            theRepository.save(the);
            Users user = new Users();
            user.setGioitinh(dto.getSex());
            user.setMaThe(the.getId());
            user.setIsTeacher(Boolean.TRUE);
            user.setLuongcoban(dto.getLuongcoban());
            user.setNgaysinh(dto.getBirthday());
            user.setName(dto.getName());
            user.setSodt(dto.getSodt());
            String maGV = "GV_" + the.getId();
            user.setIdUser(maGV);
            user.setSocmt(dto.getCmt());
            giaoVienDAO.save(user);
            UserLopMapper userLopMapper = new UserLopMapper();
            userLopMapper.setIdUser(user.getId());
            userLopMapper.setIdLop(dto.getIdLop());
            userLopMapperRepository.save(userLopMapper);
            CardDTO cardDTO = modelMap.map(the, CardDTO.class);
            cardDTO.setPassword("123456");
            cardDTO.setMaGV(maGV);
            return CommonResult.success(cardDTO);
        }
        return CommonResult.failed();
    }

    @Override
    public void update(GiaoVienDTO dto) throws ResultException {
        log.info(" start service to editLopHoc with :{}", dto);
        Users user = giaoVienDAO.findById(dto.getId(), Users.class).get();
        if (user.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        user.setLuongcoban(dto.getLuongcoban());
        user.setName(dto.getName());
        user.setSodt(dto.getSodt());
        user.setSocmt(dto.getCmt());
        user.setGioitinh(dto.getSex());
        user.setNgaysinh(dto.getNgaySinh());
        UserLopMapper userLopMapper = new UserLopMapper();
        userLopMapper.setIdUser(user.getId());
        userLopMapper.setIdLop(dto.getIdLop());
        userLopMapperRepository.save(userLopMapper);
        giaoVienDAO.update(user);
    }

    @Override
    public void delete(Integer id) throws ResultException {
        log.info(" start service to delete Lop with id:{}", id);
        Users user = giaoVienDAO.findById(id, Users.class).get();
        if (user.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        The the = theRepository.getOne(user.getMaThe());
        List<UserLopMapper> lopMapper = userLopMapperRepository.findByIdUser(user.getId());
        if (!lopMapper.isEmpty()) {
            userLopMapperRepository.deleteAll(lopMapper);
        }
        List<Baiviet> baiviets = baivietRepository.getListBVByIdUser(user.getId());
        if (!baiviets.isEmpty()) {
            baivietRepository.deleteAll(baiviets);
        }
        List<Comment> comments = commentRepository.findByIdUser(user.getId());
        if (!comments.isEmpty()) {
            commentRepository.deleteAll(comments);
        }
        List<Repcomment> repcomments = repcommentRepository.findByIdUser(user.getId());
        if (!repcomments.isEmpty()) {
            repcommentRepository.deleteAll(repcomments);
        }
        theRepository.delete(the);
        giaoVienDAO.delete(user);
    }

    @Override
    public GiaoVienDTO findById(Integer id) {
        Users user = giaoVienDAO.findById(id, Users.class).get();
        GiaoVienDTO dto = modelMap.map(user, GiaoVienDTO.class);
        return dto;
    }

    @Override
    public boolean checkMaGV(String maGV) {
        return false;
    }

    @Override
    public Integer countGVALL() {
        return theRepository.countALLGV().size();
    }

    @Override
    public Integer countGVActive() {
        return theRepository.countALLGVActive().size();
    }
}
