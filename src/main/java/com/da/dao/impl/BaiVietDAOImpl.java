package com.da.dao.impl;

import java.util.HashMap;

import java.util.Map;

import com.da.dto.BaiVietSearchDTO;
import com.da.dto.BaiVietTotalSearchDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.da.dao.BaiVietDAO;

@Repository
public class BaiVietDAOImpl extends AbstractDAO implements BaiVietDAO {
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

    @Override
    public void searchBaiVietToTal(BaiVietTotalSearchDTO searchDTO) {
        log.info("Start dao searchBaiVietToTal with :{}", searchDTO);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> param = new HashMap<>();
        sb.append(" select  bv.id as idBV,");
        sb.append(" bv.ma_baiviet as maBV,");
        sb.append("  bv.noidung  as noidungBV,");
        sb.append(" bv.title as titleBV,");
        sb.append(" bv.luotthich as luotthich,");
        sb.append("  bv.luotkhongthich as luotkhongthich,");
        sb.append("  bv.id_user as idUserBV,");
        sb.append(" bv.ma_chude as maChuDe,");
        sb.append(" cd.tenchude as tenchude,");
        sb.append(" cd.id as idChuDe, ");
        sb.append(" bv.created_date as createDate,");
        sb.append(" bv.image_path as imageBV,");
        sb.append(" u.image_path as imageUser,");
        sb.append(" u.id as idUser,");
        sb.append(" u.name as nameUser,");
        sb.append("  count(distinct cm.id) as cmCount,");
        sb.append(" count(distinct rcm.id) as rcmCount");
        sb.append(" from baiviet as bv");
        sb.append(" left outer JOIN users as u on u.id = bv.id_user");
        sb.append(" left outer JOIN chude as cd on cd.id = bv.ma_chude");
        sb.append("  left outer JOIN comment as cm on cm.id_baiviet = bv.id   or cm.id_baiviet is  null");
        sb.append(" left outer JOIN repcomment as rcm on rcm.id_comment = cm.id or rcm.id_comment is  null");
        if (StringUtils.isNotBlank(searchDTO.getTitleBV())) {
            sb.append(" where bv.title like :p_title");
            param.put("p_title", "%" + searchDTO.getTitleBV().trim() + "%");
        }
        if (searchDTO.getIdChuDe() != null && searchDTO.getIdChuDe() > 0) {
            sb.append(" where cd.id =:p_idcd");
            param.put("p_idcd", searchDTO.getIdChuDe());
        }
        sb.append("  group by bv.id, bv.ma_baiviet, bv.noidung, bv.title, bv.luotthich, bv.luotkhongthich,");
        sb.append(" bv.id_user, bv.ma_chude, bv.created_date , bv.image_path, u.image_path, u.id, u.name");
        sb.append(" order by bv.created_date desc");
        searchAndCountTotal(searchDTO, sb.toString(), param, BaiVietTotalSearchDTO.class);
    }
}

