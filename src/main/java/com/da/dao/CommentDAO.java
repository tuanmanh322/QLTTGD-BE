package com.da.dao;

import com.da.dto.CommentSearchDTO;

import java.io.Serializable;

public interface CommentDAO extends Serializable,BaseDAO{
    void searchComment(CommentSearchDTO dto);
}
