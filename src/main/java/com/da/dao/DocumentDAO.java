package com.da.dao;

import com.da.dto.DocumentSearchDTO;

import java.io.Serializable;

public interface DocumentDAO extends Serializable,BaseDAO {
    void searchDocument(DocumentSearchDTO documentSearchDTO, Integer idThe);
}
