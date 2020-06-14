package com.da.dao.impl;

import com.da.dao.DocumentDAO;
import com.da.dto.DocumentSearchDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DocumentDAOImpl extends AbstractDAO implements DocumentDAO {

    private final Logger log = LoggerFactory.getLogger(DocumentDAOImpl.class);

    @Override
    public void searchDocument(DocumentSearchDTO documentSearchDTO, Integer idThe) {
        log.info("start dao to searchDocument with : {} ",documentSearchDTO);
        StringBuilder sb = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        sb.append(" select dc.id, ");
        sb.append(" dc.title ,");
        sb.append(" dc.noidung,");
        sb.append(" dc.created_date as createdDate,");
        sb.append(" dc.link_download as linkDownload");
        sb.append(" from document as dc");
        sb.append(" left join the as t on t.id = dc.id_the");
        sb.append(" where 1 = 1 ");
        if (idThe != null){
            sb.append(" and t.id=:p_the");
            params.put("p_the",idThe);
        }

        if (documentSearchDTO.getStartDate() != null && documentSearchDTO.getEndDate() !=null){
            sb.append(" and dc.created_date >= :p_startdate and dc.created_date <= :p_enddate ");
            params.put("p_startdate", documentSearchDTO.getStartDate());
            params.put("p_enddate", documentSearchDTO.getEndDate());
        }
        if (StringUtils.isNotBlank(documentSearchDTO.getTitle())){
            sb.append(" and dc.title=:p_title");
            params.put("p_title","%" + documentSearchDTO.getTitle() + "%");
        }
        sb.append(" order by dc.title");
        searchAndCountTotal(documentSearchDTO,sb.toString(),params,DocumentSearchDTO.class);

    }
}
