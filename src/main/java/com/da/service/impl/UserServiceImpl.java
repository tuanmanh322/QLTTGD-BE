package com.da.service.impl;

import com.da.common.CommonResult;
import com.da.common.FileUploadURL;
import com.da.common.RandomString;
import com.da.dto.UserDTO;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.Lop;
import com.da.model.Roles;
import com.da.model.The;
import com.da.model.Users;
import com.da.repository.LopRepository;
import com.da.repository.RolesRepository;
import com.da.repository.TheRepository;
import com.da.repository.UsersRepository;
import com.da.security.SecurityUtils;
import com.da.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UsersRepository usersRepository;

    private final RolesRepository rolesRepository;

    private final TheRepository theRepository;

    private final LopRepository lopRepository;

    private final ModelMapper modelMapper;

    public UserServiceImpl(UsersRepository usersRepository, RolesRepository rolesRepository, TheRepository theRepository, LopRepository lopRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.rolesRepository = rolesRepository;
        this.theRepository = theRepository;
        this.lopRepository = lopRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO getCurrentUserLogin() {
        log.info("start service to getCurrentUserLogin");
        Integer idThe = SecurityUtils.getCurrentUserIdLogin();
        The the = theRepository.findById(idThe).get();
        UserDTO userDTO = new UserDTO();
        userDTO.setId(the.getId());
        userDTO.setMaThe(the.getMaThe());
        userDTO.setNgaycap(the.getNgaycap());
        userDTO.setTrangthai(the.getTrangthai());
        userDTO.setMaLoaithe(the.getMaLoaithe());
        userDTO.setPassword(the.getPassword());
        Users u = usersRepository.findByMaThe(the.getId());
        userDTO.setName(u.getName());
        userDTO.setIdUser(u.getIdUser());
        userDTO.setGioitinh(u.getGioitinh());
        userDTO.setNgaysinh(u.getNgaysinh());
        userDTO.setSocmt(u.getSocmt());
        userDTO.setQuoctich(u.getQuoctich());
        userDTO.setQuequan(u.getQuequan());
        userDTO.setNoiohientai(u.getNoiohientai());
        userDTO.setHokhau(u.getHokhau());
        userDTO.setQuatrinhlamviec(u.getQuatrinhlamviec());
        userDTO.setSodt(u.getSodt());
        userDTO.setLuongcoban(u.getLuongcoban());
        userDTO.setEmail(u.getEmail());
        userDTO.setImagePath(u.getImagePath());
        if (u.getMaLop() != null) {
            Optional<Lop> lop = lopRepository.findById(u.getMaLop());
            lop.ifPresent(value -> userDTO.setTenLop(value.getTenlop()));
        }
        if (the.getIdRole() != null) {
            Optional<Roles> roles = rolesRepository.findById(the.getIdRole());
            roles.ifPresent(value -> userDTO.setRole(value.getNameRole()));
        }
        return userDTO;
    }

    @Override
    public CommonResult addUser(UserDTO dto) throws ResultException {
        log.info("start service to addUser with: {}",dto);
        The t = new The();
        String maThe = RandomString.rdMaThe("1515");
        Optional<The> the = theRepository.findByMaThe(maThe);
        if (the.isPresent()){
            throw new ResultException(ErrorCode.RECORD_EXISTED);
        }
        t.setMaThe(maThe);
        t.setIdRole(dto.getIdRole());
        t.setNgaycap(new Date());
        t.setPassword(passwordEncoder.encode(dto.getPassword()));
        t.setTrangthai(Boolean.TRUE);
        t.setMaLoaithe(dto.getMaLoaithe());
        theRepository.save(t);
        Users u = new Users();
        Optional<Users> users =  usersRepository.findByEmail(dto.getEmail());
        if (users.isPresent()){
            throw new ResultException(ErrorCode.EMAIL_EXISTED);
        }
        u.setMaThe(t.getId());
        u.setName(dto.getName());
        u.setGioitinh(dto.getGioitinh());
        u.setNgaysinh(dto.getNgaysinh());
        u.setSocmt(dto.getSocmt());
        u.setQuoctich(dto.getQuoctich());
        u.setQuequan(dto.getQuequan());
        u.setNoiohientai(dto.getNoiohientai());
        u.setHokhau(dto.getHokhau());
        u.setQuatrinhlamviec(dto.getQuatrinhlamviec());
        u.setEmail(dto.getEmail());
        u.setSodt(dto.getSodt());
        u.setLuongcoban(dto.getLuongcoban());
        if (!dto.getImageAvatar().isEmpty()){
            try {
                u.setImagePath(FileUploadURL.saveFileAndGetUrl(dto.getImageAvatar()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new ResultException(ErrorCode.RECORD_NOT_FOUND);
            }
        }
        usersRepository.save(u);
        return CommonResult.success(maThe);

    }

    @Override
    public boolean checkEmail(String email) {
        log.info("start service to checkEmail with {}: ",email);
        Optional<Users> users = usersRepository.findByEmail(email.trim());
        return users.isPresent();
    }

    @Override
    public CommonResult register(UserDTO dto) throws ResultException {
        log.info("start service to register with: {}",dto);
        The t = new The();
        String maThe = "";
        if (dto.getIdRole() == 2){
             maThe = RandomString.rdMaThe("1111");
            Optional<The> the = theRepository.findByMaThe(maThe);
            if (the.isPresent()){
                switch ((int) (Math.random()* 4) + 1){
                    case 1:
                        maThe = RandomString.rdMaThe("1212");
                        break;
                    case 2:
                        maThe = RandomString.rdMaThe("1313");
                        break;
                    case 3:
                        maThe = RandomString.rdMaThe("1414");
                        break;
                    case 4:
                        maThe = RandomString.rdMaThe("1515");
                        break;
                }
                t.setMaThe(maThe);
            }else {
                t.setMaThe(maThe);
            }
        }
        if (dto.getIdRole() == 3){
            maThe = RandomString.rdMaThe("1616");
            Optional<The> the = theRepository.findByMaThe(maThe);
            if (the.isPresent()){
                switch ((int) (Math.random()* 4) + 1){
                    case 1:
                        maThe = RandomString.rdMaThe("1717");
                        break;
                    case 2:
                        maThe = RandomString.rdMaThe("1818");
                        break;
                    case 3:
                        maThe = RandomString.rdMaThe("1919");
                        break;
                    case 4:
                        maThe = RandomString.rdMaThe("2020");
                        break;
                }
                t.setMaThe(maThe);
            }else {
                t.setMaThe(maThe);
            }
        }
        t.setIdRole(dto.getIdRole());
        t.setNgaycap(new Date());
        t.setPassword(passwordEncoder.encode(dto.getPassword()));
        t.setTrangthai(Boolean.TRUE);
        theRepository.save(t);
        Users u = new Users();
        Optional<Users> users =  usersRepository.findByEmail(dto.getEmail());
        if (users.isPresent()){
            throw new ResultException(ErrorCode.EMAIL_EXISTED);
        }
        u.setEmail(dto.getEmail());
        u.setName(dto.getName());
        u.setMaThe(t.getId());
        usersRepository.save(u);
        return CommonResult.success(maThe);
    }

    @Override
    public void updateProfile(UserDTO dto) throws ResultException {
        log.info("start service to updateProfile with :{}",dto);
        Optional<The> the = theRepository.findById(SecurityUtils.getCurrentUserIdLogin());
        if (the.isPresent()){
            Users users = usersRepository.findByMaThe(the.get().getId());
            users = modelMapper.map(dto,Users.class);
            if (dto.getImageAvatar() != null){
                try {
                    users.setImagePath(FileUploadURL.saveFileAndGetUrl(dto.getImageAvatar()));
                } catch (Exception e) {
                    e.printStackTrace();
                    throw  new ResultException(ErrorCode.FILE_UPLOAD_FAILED);
                }
            }
            usersRepository.save(users);
        }
    }
}
