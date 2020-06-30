package com.da.dao.impl;

import com.da.dao.NhatKyCheckInDAO;
import com.da.dto.NhatKySearchDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class NhatKyCheckInDAOImpl extends AbstractDAO implements NhatKyCheckInDAO {
    @Override
    public void searchNk(NhatKySearchDTO nhatKySearchDTO) {
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        sb.append(" select distinct u.name as userName,");
        sb.append(" t.id as idThe,");
        sb.append(" t.ma_the as maThe,");
        sb.append(" lo.tenlop as tenLop,");
        sb.append(" ck.thoigianvao as ngayCheckIn");
        sb.append(" from the as t");
        sb.append(" left join users as u on u.ma_the = t.id");
        sb.append(" left join nhatcheckin as ck on ck.ma_the = t.id  and ck.ma_the is not null");
        sb.append(" left join user_lop_mapper as ulm on ulm.id_user= u.id and ck.id_lop = ulm.id_lop");
        sb.append(" left join lop as lo on lo.id = ck.id_lop");
        sb.append(" where 1 = 1 ");
        sb.append(" and ck.thoigianvao is not null");
        if (StringUtils.isNotBlank(nhatKySearchDTO.getTenLop())) {
            sb.append(" and lo.tenlop like :p_tenlop");
            params.put("p_tenlop", "%" + nhatKySearchDTO.getTenLop().trim() + "%");
        }

        if (nhatKySearchDTO.getTuNgay() != null && nhatKySearchDTO.getDenNgay() != null) {
            sb.append(" and ck.thoigianvao >= :p_tungay ");
            params.put("p_tungay", nhatKySearchDTO.getTuNgay());
            sb.append(" and ck.thoigianvao <= :p_denngay");
            params.put("p_denngay", nhatKySearchDTO.getDenNgay());
        }
        sb.append(" order by ck.thoigianvao desc");

        searchAndCountTotal(nhatKySearchDTO, sb.toString(), params, NhatKySearchDTO.class);
    }
}
