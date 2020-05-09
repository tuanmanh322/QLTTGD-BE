package com.da.dao;

import com.da.dto.RepCommentSearchDTO;

import java.io.Serializable;

public interface RepCommentDAO extends Serializable,BaseDAO{
    void searchRepComment(RepCommentSearchDTO repCommentDTO);
}
