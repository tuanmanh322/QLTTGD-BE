package com.da.dao.impl;

import com.da.dao.MonHocDAO;
import com.da.dto.MonHocSearchDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MonHocDAOImpl extends AbstractDAO implements MonHocDAO {
    @Override
    public void searchMH(MonHocSearchDTO dto) {
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> param = new HashMap<>();
        sb.append(" select mh.id as id,");
        sb.append(" mh.ma_monhoc as maMonHoc,");
        sb.append(" mh.tenmonhoc as tenMonHoc");
        sb.append(" from monhoc as mh");
        sb.append(" where 1 = 1");
        if (StringUtils.isNotBlank(dto.getTenMonHoc())) {
            sb.append(" and mh.tenmonhoc like :p_tenMH");
            param.put("p_tenMH", "%" + dto.getTenMonHoc().trim() + "%");
        }
        if (StringUtils.isNotBlank(dto.getMaMonHoc())) {
            sb.append(" and mh.ma_monhoc like :p_mamh");
            param.put("p_mamh", "%" + dto.getMaMonHoc().trim() + "%");
        }

        sb.append(" order by mh.tenmonhoc");

        searchAndCountTotal(dto, sb.toString(), param, MonHocSearchDTO.class);
    }
}
