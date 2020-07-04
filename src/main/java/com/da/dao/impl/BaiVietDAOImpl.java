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
        sb.append(" select distinct  bv.id ,");
        sb.append(" bv.ma_baiviet as mabaiviet,");
        sb.append(" bv.title as titleBV,");
        sb.append(" bv.noidung as noidung,");
        sb.append(" bv.luotthich as luotthich,");
        sb.append(" bv.luotkhongthich as luotkhongthich,");
        sb.append(" bv.trangthai as active,");
        sb.append(" bv.created_date as createDate,");
        sb.append(" u.name as username,");
        sb.append(" cd.tenchude as tenChuDe,");
        sb.append(" t.ma_the as maThe");
        sb.append(" from BAIVIET as bv");
        sb.append(" left join CHUDE as cd on bv.ma_chude = cd.id");
        sb.append(" left join the as t on t.id = bv.id_the");
        sb.append(" left join users as  u on u.ma_the = t.id");
        sb.append(" where 1=1");
        if (StringUtils.isNotBlank(dto.getTenChuDe())){
            sb.append(" and cd.tenchude like :p_tencd");
            parameter.put("p_tencd","%" + dto.getTenChuDe() + "%");
        }
        if (dto.getActive() != null) {
            sb.append(" and bv.trangthai=:p_active");
            parameter.put("p_active", dto.getActive());
        }
        if (StringUtils.isNotBlank(dto.getTitleBV())) {
            sb.append(" and bv.title like :p_title");
            parameter.put("p_title ", "%" + dto.getTitleBV().trim() + "%");
        }
        if (StringUtils.isNotBlank(dto.getNoidung())) {
            sb.append(" and bv.noidung like :p_noidung");
            parameter.put("p_noidung ", "%" + dto.getNoidung().trim() + "%");
        }
        if (dto.getOrders() != null && !dto.getOrders().isEmpty()) {
            sb.append(" order by ");
            dto.getOrders().forEach(order -> {
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
        sb.append("  bv.id_the as idUserBV,");
        sb.append(" bv.ma_chude as maChuDe,");
        sb.append(" bv.view_count as viewCounts,");
        sb.append(" cd.tenchude as tenchude,");
        sb.append(" cd.id as idChuDe, ");
        sb.append(" bv.created_date as createDate,");
        sb.append(" bv.image_path as imageBV,");
        sb.append(" u.image_path as imageUser,");
        sb.append(" u.id as idUser,");
        sb.append(" u.name as nameUser,");
        sb.append(" t.id as idThe,");
        sb.append("  count(distinct cm.id) as cmCount,");
        sb.append(" count(distinct rcm.id) as rcmCount");
        sb.append(" from baiviet as bv");
        sb.append(" left outer join the as t on t.id = bv.id_the");
        sb.append(" left outer JOIN users as u on u.ma_the = bv.id_the");
        sb.append(" left outer JOIN chude as cd on cd.id = bv.ma_chude");
        sb.append("  left outer JOIN comment as cm on cm.id_baiviet = bv.id   or cm.id_baiviet is  null");
        sb.append(" left outer JOIN repcomment as rcm on rcm.id_comment = cm.id or rcm.id_comment is  null");
        sb.append(" where 1 = 1 and bv.trangthai = 1");
        if (StringUtils.isNotBlank(searchDTO.getTitleBV())) {
            sb.append(" and bv.title like :p_title");
            param.put("p_title", "%" + searchDTO.getTitleBV().trim() + "%");
        }
        if (searchDTO.getIdChuDe() != null && searchDTO.getIdChuDe() > 0) {
            sb.append(" and cd.id =:p_idcd");
            param.put("p_idcd", searchDTO.getIdChuDe());
        }
        sb.append("  group by bv.id, bv.ma_baiviet, bv.noidung, bv.title, bv.luotthich, bv.luotkhongthich,");
        sb.append(" bv.id_the, bv.ma_chude, bv.created_date , bv.image_path, u.image_path, u.id, u.name, t.id");
        sb.append(" order by bv.created_date desc");
        searchAndCountTotal(searchDTO, sb.toString(), param, BaiVietTotalSearchDTO.class);
    }

    @Override
    public void searchBaiVietToTalByIdCD(BaiVietTotalSearchDTO searchDTO, Integer idCd) {
        log.info("Start dao searchBaiVietToTal with :{} and idCD: {}", searchDTO, idCd);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> param = new HashMap<>();
        sb.append(" select  bv.id as idBV,");
        sb.append(" bv.ma_baiviet as maBV,");
        sb.append("  bv.noidung  as noidungBV,");
        sb.append(" bv.title as titleBV,");
        sb.append(" bv.luotthich as luotthich,");
        sb.append("  bv.luotkhongthich as luotkhongthich,");
        sb.append("  bv.id_the as idUserBV,");
        sb.append(" bv.ma_chude as maChuDe,");
        sb.append(" bv.view_count as viewCounts,");
        sb.append(" cd.tenchude as tenchude,");
        sb.append(" cd.id as idChuDe, ");
        sb.append(" bv.created_date as createDate,");
        sb.append(" bv.image_path as imageBV,");
        sb.append(" u.image_path as imageUser,");
        sb.append(" u.id as idUser,");
        sb.append(" u.name as nameUser,");
        sb.append(" t.id as idThe,");
        sb.append("  count(distinct cm.id) as cmCount,");
        sb.append(" count(distinct rcm.id) as rcmCount");
        sb.append(" from baiviet as bv");
        sb.append(" left outer join the as t on t.id = bv.id_the");
        sb.append(" left outer JOIN users as u on u.ma_the = bv.id_the");
        sb.append(" left outer JOIN chude as cd on cd.id = bv.ma_chude");
        sb.append("  left outer JOIN comment as cm on cm.id_baiviet = bv.id   or cm.id_baiviet is  null");
        sb.append(" left outer JOIN repcomment as rcm on rcm.id_comment = cm.id or rcm.id_comment is  null");
        sb.append(" where 1 = 1 and bv.trangthai = 1");
        if (idCd != null) {
            sb.append(" and cd.id =:p_idCd");
            param.put("p_idCd", idCd);
        }
        if (StringUtils.isNotBlank(searchDTO.getTitleBV())) {
            sb.append(" and bv.title like :p_title");
            param.put("p_title", "%" + searchDTO.getTitleBV().trim() + "%");
        }
        if (searchDTO.getIdChuDe() != null && searchDTO.getIdChuDe() > 0) {
            sb.append(" and cd.id =:p_idcd");
            param.put("p_idcd", searchDTO.getIdChuDe());
        }
        sb.append("  group by bv.id, bv.ma_baiviet, bv.noidung, bv.title, bv.luotthich, bv.luotkhongthich,");
        sb.append(" bv.id_the, bv.ma_chude, bv.created_date , bv.image_path, u.image_path, u.id, u.name, t.id");
        sb.append(" order by bv.created_date desc");
        searchAndCountTotal(searchDTO, sb.toString(), param, BaiVietTotalSearchDTO.class);

    }

    @Override
    public void searchTuongTac(BaiVietTotalSearchDTO searchDTO, Integer idThe) {
        log.info("Start dao searchBaiVietToTal with :{} and idThe: {}", searchDTO, idThe);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        sb.append(" select bv.id,");
        sb.append(" bv.created_date as createDate,");
        sb.append(" bv.title as titleBV,");
        sb.append(" bv.noidung as noidungBV,");
        sb.append(" bv.luotthich as luotthich,");
        sb.append(" bv.luotkhongthich as luotkhongthich");
        sb.append(" from baiviet as bv");
        sb.append(" left join users as u on u.ma_the = bv.id_the");
        sb.append(" where 1 = 1 ");
        if (idThe != null) {
            sb.append(" and u.ma_the=:p_maThe ");
            params.put("p_maThe", idThe);
        }
        if (searchDTO.getStartDate() != null && searchDTO.getEndDate() != null) {
            sb.append(" and bv.created_date >= :p_startdate and bv.created_date <= :p_enddate ");
            params.put("p_startdate", searchDTO.getStartDate());
            params.put("p_enddate", searchDTO.getEndDate());
        }

        sb.append(" order by bv.title");

        searchAndCountTotal(searchDTO, sb.toString(), params, BaiVietTotalSearchDTO.class);
    }
}

