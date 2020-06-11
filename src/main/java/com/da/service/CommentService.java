package com.da.service;

import com.da.dto.CommentDTO;
import com.da.dto.CommentSearchDTO;
import com.da.exception.ResultException;

public interface CommentService {
    void searchComment(CommentSearchDTO dto);
    void add(CommentDTO dto) throws ResultException;
    void update(CommentDTO dto)throws ResultException;
    void delete(Integer id)throws ResultException;
    CommentDTO findById(Integer id);

    boolean isCommentBV(Integer idBV, CommentDTO commentDTO);
}
