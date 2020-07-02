package com.da.service.impl;

import com.da.common.Constant;
import com.da.common.ParseDiemTB;
import com.da.dao.DiemDAO;
import com.da.dto.DiemActionDTO;
import com.da.dto.DiemDTO;
import com.da.dto.DiemSearchDTO;
import com.da.dto.DiemToExcelDTO;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.*;
import com.da.repository.*;
import com.da.security.SecurityUtils;
import com.da.security.UserTypeEnum;
import com.da.service.DiemService;
import com.da.service.HocSinhService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DiemServiceImpl implements DiemService {
    private final Logger log = LoggerFactory.getLogger(HocSinhService.class);

    private final String PASSWORD = "123456";

    private final ModelMapper modelMap;

    private final DiemDAO diemDAO;

    private final UsersRepository usersRepository;

    private final LopRepository lopRepository;

    private final UsersDiemMapRepository usersDiemMapRepository;

    private final UserLopMapperRepository userLopMapperRepository;

    private final DiemRepository diemRepository;

    private final MonhocRepository monhocRepository;

    private final TheRepository theRepository;

    private final PasswordEncoder passwordEncoder;

    public DiemServiceImpl(ModelMapper modelMap, DiemDAO diemDAO, UsersRepository usersRepository, LopRepository lopRepository, UsersDiemMapRepository usersDiemMapRepository, UserLopMapperRepository userLopMapperRepository, DiemRepository diemRepository, MonhocRepository monhocRepository, TheRepository theRepository, PasswordEncoder passwordEncoder) {
        this.modelMap = modelMap;
        this.diemDAO = diemDAO;
        this.usersRepository = usersRepository;
        this.lopRepository = lopRepository;
        this.usersDiemMapRepository = usersDiemMapRepository;
        this.userLopMapperRepository = userLopMapperRepository;
        this.diemRepository = diemRepository;
        this.monhocRepository = monhocRepository;
        this.theRepository = theRepository;
        this.passwordEncoder = passwordEncoder;
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
            UserLopMapper userLopMapper = userLopMapperRepository.findByUserAndLop(u.getId(), dto.getIdLopOld());
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
        return diemDAO.getAllByIdThe(ud);
    }

    @Override
    public void readAndWriteDateFromExcel(MultipartFile file,Integer idUser) {
        log.info(" start service to readAndWriteDateFromExcel : {} and idUSer: {}", file,idUser);
        try {
            int i = 1;
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            XSSFSheet workSheet = workbook.getSheetAt(0);
            Iterator rows = workSheet.iterator();
            while (rows.hasNext()) {
                Row ro = (Row) rows.next();
                if (ro.getRowNum() == 0) {
                    continue;
                }
                Iterator cells = ro.cellIterator();
                while (i <= workSheet.getLastRowNum()) {
                    The t = new The();
                    Users users = new Users();
                    Diem diem = new Diem();
                    UsersDiemMap usersDiemMap = new UsersDiemMap();
                    UserLopMapper userLopMapper = new UserLopMapper();
                    Lop lop = new Lop();
                    Monhoc monhoc = new Monhoc();
                    XSSFRow row = workSheet.getRow(i++);
                    Optional<The> the = theRepository.findByMaTheExcel((int)row.getCell(0).getNumericCellValue());
                    if (the.isPresent()) {
                        Users u = usersRepository.findByMaThe(the.get().getId());
                        diem.setDiemmieng(row.getCell(3).getNumericCellValue());
                        diem.setDiem15p(row.getCell(4).getNumericCellValue());
                        diem.setDiem90p(row.getCell(5).getNumericCellValue());
                        diem.setDiemtb(row.getCell(6).getNumericCellValue());
                        diemRepository.save(diem);
                        usersDiemMap.setIdUser(u.getId());
                        usersDiemMap.setIdDiem(diem.getId());
                        usersDiemMapRepository.save(usersDiemMap);
                        Optional<Lop> lo = lopRepository.findBYmAlOP(row.getCell(8).getStringCellValue().trim());
                        if (lo.isPresent()) {
                            userLopMapper.setIdLop(lo.get().getId());
                            userLopMapper.setIdUser(u.getId());
                            userLopMapper.setActive(true);
                            userLopMapperRepository.save(userLopMapper);
                            UserLopMapper lopMapper = new UserLopMapper();
                            lopMapper.setIdUser(idUser);
                            lopMapper.setIdLop(lo.get().getId());
                            lopMapper.setActive(true);
                            userLopMapperRepository.save(lopMapper);
                        } else {
                            lop.setTenlop(row.getCell(9).getStringCellValue().trim());
                            lop.setKipDay(row.getCell(7).getStringCellValue().trim());
                            lop.setMaLop(row.getCell(8).getStringCellValue().trim());
                            Optional<Monhoc> mh = monhocRepository.findMamonHocOp( row.getCell(10).getStringCellValue().trim());
                            if (mh.isPresent()) {
                                lop.setMaMonhoc(mh.get().getId());
                            } else {
                                monhoc.setMaMonhoc(row.getCell(10).getStringCellValue().trim());
                                monhoc.setTenmonhoc(row.getCell(11).getStringCellValue().trim());
                                monhocRepository.save(monhoc);
                                lop.setMaMonhoc(monhoc.getId());
                            }
                            lopRepository.save(lop);
                            userLopMapper.setIdUser(idUser);
                            userLopMapper.setIdLop(lop.getId());
                            userLopMapper.setActive(true);
                            userLopMapperRepository.save(userLopMapper);
                            UserLopMapper lopMapper = new UserLopMapper();
                            lopMapper.setIdUser(idUser);
                            lopMapper.setIdLop(lop.getId());
                            lopMapper.setActive(true);
                            userLopMapperRepository.save(lopMapper);
                        }
                    } else {
                        String maThe = "" + row.getCell(0).getNumericCellValue();
                        String newMaThe = maThe.replace(".","");
                        t.setIdRole(UserTypeEnum.STUDENT.getId());
                        t.setTrangthai(true);
                        t.setNgaycap(new Date());
                        t.setPassword(passwordEncoder.encode(PASSWORD.trim()));
                        t.setMaThe(newMaThe.substring(0,newMaThe.indexOf("E")));
                        theRepository.save(t);
                        users.setName(row.getCell(1).getStringCellValue().trim());
                        users.setNgaysinh(row.getCell(2).getDateCellValue());
                        users.setIsTeacher(false);
                        users.setMaThe(t.getId());
                        usersRepository.save(users);
                        diem.setDiemmieng(row.getCell(3).getNumericCellValue());
                        diem.setDiem15p(row.getCell(4).getNumericCellValue());
                        diem.setDiem90p(row.getCell(5).getNumericCellValue());
                        diem.setDiemtb(row.getCell(6).getNumericCellValue());
                        diemRepository.save(diem);
                        usersDiemMap.setIdUser(users.getId());
                        usersDiemMap.setIdDiem(diem.getId());
                        usersDiemMapRepository.save(usersDiemMap);
                        Optional<Lop> lo = lopRepository.findBYmAlOP(row.getCell(8).getStringCellValue().trim());
                        if (lo.isPresent()) {
                            userLopMapper.setIdLop(lo.get().getId());
                            userLopMapper.setIdUser(users.getId());
                            userLopMapper.setActive(true);
                            userLopMapperRepository.save(userLopMapper);
                            UserLopMapper lopMapper = new UserLopMapper();
                            lopMapper.setIdUser(idUser);
                            lopMapper.setIdLop(lo.get().getId());
                            lopMapper.setActive(true);
                            userLopMapperRepository.save(lopMapper);
                        } else {
                            lop.setTenlop(row.getCell(9).getStringCellValue().trim());
                            lop.setKipDay(row.getCell(7).getStringCellValue().trim());
                            lop.setMaLop(row.getCell(8).getStringCellValue().trim());
                            Optional<Monhoc> mh = monhocRepository.findMamonHocOp(row.getCell(10).getStringCellValue().trim());
                            if (mh.isPresent()) {
                                lop.setMaMonhoc(mh.get().getId());
                            } else {
                                monhoc.setMaMonhoc(row.getCell(10).getStringCellValue().trim());
                                monhoc.setTenmonhoc(row.getCell(11).getStringCellValue().trim());
                                monhocRepository.save(monhoc);
                                lop.setMaMonhoc(monhoc.getId());
                            }
                            lopRepository.save(lop);
                            userLopMapper.setIdLop(lop.getId());
                            userLopMapper.setIdUser(users.getId());
                            userLopMapper.setActive(true);
                            userLopMapperRepository.save(userLopMapper);
                            UserLopMapper lopMapper = new UserLopMapper();
                            lopMapper.setIdUser(idUser);
                            lopMapper.setIdLop(lop.getId());
                            lopMapper.setActive(true);
                            userLopMapperRepository.save(lopMapper);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
