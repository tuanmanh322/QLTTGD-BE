package com.da.dao.impl;

import com.da.dao.HangMucDAO;
import com.da.dto.HangMucSearchDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class HangMucDAOImpl extends AbstractDAO implements HangMucDAO {
    private final Logger log = LoggerFactory.getLogger(HangMucDAOImpl.class);
   @Override
    public void searchHangMuc(HangMucSearchDTO dto){
        log.info("Start dao searchHangmuc with :{}",dto);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> parameter = new HashMap<>();
        sb.append(" select distinct hm.id,");
        sb.append(" hm.ma_hangmucbaiviet as maHangmucbaiviet,");
        sb.append(" hm.mota as moTa ,");
        sb.append(" mh.ma_monhoc as maMonhoc,");
       sb.append(" hm.tenhangmuc as tenhangmuc, ");
       sb.append(" mh.tenmonhoc as tenMonHoc ");
        sb.append(" from HANGMUC as hm ");
        sb.append(" left join MONHOC as mh on hm.ma_monhoc= mh.id where 1=1");
       if (StringUtils.isNotBlank(dto.getMaHangmucbaiviet())) {
           sb.append(" and hm.ma_hangmucbaiviet like :p_ma_hangmucbaiviet ");
           parameter.put("p_ma_hangmucbaiviet", "%" + dto.getMaHangmucbaiviet().trim() + "%");
       }
       if (StringUtils.isNotBlank(dto.getTenhangmuc())) {
           sb.append(" and hm.tenhangmuc like :p_tenhangmuc ");
           parameter.put("p_tenhangmuc", "%" + dto.getTenhangmuc().trim() + "%");
       }
       if (StringUtils.isNotBlank(dto.getTenMonHoc())) {
           sb.append(" and mh.tenmonhoc like :p_tenmonhoc ");
           parameter.put("p_tenmonhoc", "%" + dto.getTenMonHoc().trim() + "%");
       }
       if (dto.getOrders() != null && !dto.getOrders().isEmpty()) {
           sb.append(" order by ");
           dto.getOrders().forEach(order ->{
               String property  = StringUtils.trimToEmpty(order.getProperty());
               switch (property) {
                   case "ma_hangmucbaiviet":
                       sb.append(" hm.ma_hangmucbaiviet ").append(getOrderBy(order.isAscending())).append(",");
                       break;
               }
           });
           sb.deleteCharAt(sb.length() -1 );
       }else {
           sb.append(" order by hm.ma_hangmucbaiviet ");
       }
       searchAndCountTotal(dto, sb.toString(), parameter, HangMucSearchDTO.class);
    }
}
