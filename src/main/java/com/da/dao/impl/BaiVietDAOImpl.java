package com.da.dao.impl;

import java.util.HashMap;

import java.util.Map;

import com.da.dto.BaiVietSearchDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.da.dao.BaiVietDAO;

@Repository
public  class BaiVietDAOImpl extends AbstractDAO implements BaiVietDAO {
    private final Logger log = LoggerFactory.getLogger(BaiVietDAOImpl.class);

    public void searchBaiViet(BaiVietSearchDTO dto) {
        log.info("Start dao searchBaiViet with :{}", dto);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> parameter = new HashMap<>();
        sb.append(" select  cd.id ,");
        sb.append(" bv.ma_baiviet as maBaiviet,");
        sb.append(" bv.noidung as noiDung,");
        sb.append(" bv.luotthich as luotThich,");
        sb.append(" cd.luotkhongthich as luotKhongthich,");
        sb.append(" from BAIVIET as bv");
        sb.append(" left join CHUDE as cd on bv.ma_chude = cd.ma_chude");
        sb.append(" where 1=1");
        if (StringUtils.isNotBlank(dto.getNoidung())) {
            sb.append(" and bv.noidung like :p_noidung");
            parameter.put("p_noidung ", "%" + dto.getNoidung().trim() + "%");
        }
        if (dto.getOrderDTOS() != null && !dto.getOrderDTOS().isEmpty()) {
            sb.append(" order by ");
            dto.getOrderDTOS().forEach(order -> {
                String property = StringUtils.trimToEmpty(order.getProperty());
                switch (property) {
                    case "noidung":
                        sb.append(" bv.noidung ").append(getOrderBy(order.isAscending())).append(",");
                        break;
                }
            });
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(" order by bv.noidung  ");
        }
        searchAndCountTotal(dto, sb.toString(), parameter, BaiVietSearchDTO.class);
    }
}

