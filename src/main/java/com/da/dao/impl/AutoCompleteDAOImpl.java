package com.da.dao.impl;

import com.da.dao.AutoCompleteDAO;
import com.da.dto.AutoCompleteTitleSet;
import com.da.dto.AutocompleteSearchDTO;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class AutoCompleteDAOImpl extends AbstractDAO implements AutoCompleteDAO {
    private final Logger log = LoggerFactory.getLogger(AutoCompleteDAOImpl.class);

    @Override
    public List<AutoCompleteTitleSet> searchTitleBV(AutocompleteSearchDTO autocompleteSearchDTO) {
        log.info(" start dao to searchTitleBV with :{}",autocompleteSearchDTO);
        StringBuilder sqlBuilder = new StringBuilder();
        List<String> excludeNames = autocompleteSearchDTO.getExcludeKeywords();
        sqlBuilder.append("select new ");
        sqlBuilder.append(AutoCompleteTitleSet.class.getName());
        sqlBuilder.append("(bv.id, bv.title)");
        sqlBuilder.append(" from Baiviet bv where bv.title like :p_title");
        if(!CollectionUtils.isEmpty(excludeNames)){
            sqlBuilder.append(" and bv.title not in (:p_title_excludes)");
        }
        sqlBuilder.append(" order by bv.title");
        Query query = getSession().createQuery(sqlBuilder.toString());
        query.setParameter("p_title", "%" + autocompleteSearchDTO.getKeyword() + "%");
        if(!CollectionUtils.isEmpty(excludeNames)){
            query.setParameter("p_title_excludes", excludeNames);
        }
        query.setMaxResults(10);
        return query.getResultList();
    }
}
