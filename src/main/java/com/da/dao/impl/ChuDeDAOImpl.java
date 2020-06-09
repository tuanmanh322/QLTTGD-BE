package com.da.dao.impl;

import com.da.dao.ChuDeDAO;
import com.da.dto.ChuDeCountDTO;
import com.da.dto.ChuDeSearchDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ChuDeDAOImpl extends AbstractDAO implements ChuDeDAO {
    private final Logger log = LoggerFactory.getLogger(ChuDeDAOImpl.class);
    public void searchChuDe(ChuDeSearchDTO dto){
        log.info("Start dao searchChuDe with :{}",dto);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> parameter = new HashMap<>();
        sb.append(" select  cd.id ," );
        sb.append(" cd.ma_chude as maChude,");
        sb.append(" cd.tenchude as tenChude,");
        sb.append(" cd.noidung as noiDung,");
        sb.append(" hm.tenhangmuc as tenHangmuc");
        sb.append(" from CHUDE as cd");
        sb.append(" left join HANGMUC as hm on cd.ma_hangmucbaiviet = hm.ma_hangmucbaiviet");
        sb.append(" where 1=1");
        if (StringUtils.isNotBlank(dto.getTenchude())) {
            sb.append(" and cd.tenchude like :p_tenchude ");
            parameter.put("p_tenchude ", "%" + dto.getTenchude().trim() + "%");
        }
        if (dto.getOrderDTOS() != null && !dto.getOrderDTOS().isEmpty()) {
            sb.append(" order by ");
            dto.getOrderDTOS().forEach(order ->{
                String property  = StringUtils.trimToEmpty(order.getProperty());
                switch (property) {
                    case "tenchude":
                        sb.append(" cd.tenchude ").append(getOrderBy(order.isAscending())).append(",");
                        break;
                }
            });
            sb.deleteCharAt(sb.length() -1 );
        }else {
            sb.append(" order by cd.tenchude  ");
        }
        searchAndCountTotal(dto, sb.toString(), parameter, ChuDeSearchDTO.class);
    }

    @Override
    public List<ChuDeCountDTO> getChuAndCount() {
        log.info("Start dao getChuAndCount ");
        StringBuilder sb = new StringBuilder();
        sb.append(" select new ").append(ChuDeCountDTO.class.getName());
        sb.append(" ( cd.id,");
        sb.append(" cd.maChude as maChuDe,");
        sb.append(" cd.tenChude as tenChuDe,");
        sb.append(" count(bv.id) as baiVietCount )");
        sb.append(" from Chude as cd");
        sb.append(" left join Baiviet as bv");
        sb.append(" on (bv.ma_chude = cd.id or bv.id is  null) and bv.trangthai = 1");
        sb.append("  group by cd.id, cd.maChude,cd.tenChude");
        TypedQuery<ChuDeCountDTO> query = getSession().createQuery(sb.toString(),ChuDeCountDTO.class);
        return query.getResultList();
    }

}
