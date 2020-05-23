package com.da.service.impl;

import com.da.dto.UserDTO;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

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
}
