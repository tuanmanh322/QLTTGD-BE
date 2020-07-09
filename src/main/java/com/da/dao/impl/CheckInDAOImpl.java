package com.da.dao.impl;

import com.da.dao.CheckInDAO;
import com.da.dto.CheckInDTO;
import com.da.dto.HocSinhDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CheckInDAOImpl extends AbstractDAO implements CheckInDAO  {
    private final Logger log = LoggerFactory.getLogger(CheckInDAOImpl.class);

    public void searchCheckIn(CheckInDTO dto){
        log.info("Start dao searchHS with :{}",dto);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> parameter = new HashMap<>();
        sb.append(" select ck.id,");
        sb.append(" ck.ma_nhatky as MaNhatKy,");
        sb.append(" ck.ma_the as MaThe ,");
        sb.append(" ck.thoigianvao as Thoigianvao,");
        sb.append(" ck.ma_lop as MaLop ");
        sb.append(" from nhatcheckin as ck ");
        sb.append(" left join users as u on ck.ma_the = u.ma_the where 1=1");
        if (StringUtils.isNotBlank(dto.getTenHocSinh())) {
            sb.append(" and u.name like :p_name ");
            parameter.put("p_name", "%" + dto.getTenHocSinh().trim() + "%");
        }
        if (StringUtils.isNotBlank(dto.getMaLop())) {
            sb.append(" and u.ma_lop like :p_malop ");
            parameter.put("p_malop", "%" + dto.getMaLop().trim() + "%");
        }
        if (dto.getOrders() != null && !dto.getOrders().isEmpty()) {
            sb.append(" order by ");
            dto.getOrders().forEach(order ->{
                String property  = StringUtils.trimToEmpty(order.getProperty());
                switch (property) {
                    case "id_user":
                        sb.append(" u.id_user ").append(getOrderBy(order.isAscending())).append(",");
                        break;
                }
            });
            sb.deleteCharAt(sb.length() -1 );
        }else {
            sb.append(" order by u.id_user ");
        }
        searchAndCountTotal(dto, sb.toString(), parameter, HocSinhDTO.class);
    }

    @Override
    public void searchCheckInByProfile(CheckInDTO checkInDTO, Integer idThe) {
        log.info("Start dao searchCheckInByProfile with :{} and :{}",checkInDTO,idThe);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> parameter = new HashMap<>();
        sb.append(" select nc.id,");
        sb.append(" nc.thoigianvao as ngayVao,");
        sb.append(" u.id as idUser,");
        sb.append(" u.name as name,");
        sb.append(" t.trangthai");
        sb.append(" from nhatcheckin as nc");
        sb.append(" left join users as u on u.ma_the = nc.ma_the");
        sb.append(" left join the as t on t.id = u.ma_the");
        sb.append(" where 1=1");
        if (idThe != null){
            sb.append(" and t.id =:p_the");
            parameter.put("p_the",idThe);
        }
        sb.append(" order by  nc.thoigianvao");
        searchAndCountTotal(checkInDTO,sb.toString(),parameter,CheckInDTO.class);
    }
}
