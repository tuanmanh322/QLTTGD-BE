package com.da.service;

import com.da.dto.RepCommentDTO;
import com.da.dto.RepCommentSearchDTO;
import com.da.exception.ResultException;

public interface RepCommentService {
    void searchRepComment(RepCommentSearchDTO dto);
    void add(RepCommentDTO dto) throws ResultException;
    void update(RepCommentDTO dto)throws ResultException;
    void delete(Integer id)throws ResultException;
    RepCommentDTO findById(Integer id);
}
