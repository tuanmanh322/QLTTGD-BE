package com.da.service.impl;

import com.da.dao.CommentDAO;
import com.da.dto.CommentDTO;
import com.da.dto.CommentSearchDTO;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.Comment;
import com.da.service.CommentService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private final Logger log = LoggerFactory.getLogger(HangMucServiceImpl.class);

    private final ModelMapper modelMap;

    private final CommentDAO commentDao;

    public CommentServiceImpl(ModelMapper modelMap, CommentDAO commentDao) {
        super();
        this.modelMap = modelMap;
        this.commentDao = commentDao;
    }

    @Override
    public void searchComment(CommentSearchDTO dto) {
        log.info(" start service to searchHangMuc with :{}",dto);
        commentDao.searchComment(dto);
    }

    @Override
    public void add(CommentDTO dto) throws ResultException {
        log.info(" start service to searchChuDe with :{}",dto);
        Comment comment = modelMap.map(dto, Comment.class);
        commentDao.save(comment);
    }

    @Override
    public void update(CommentDTO dto) throws ResultException {
        log.info(" start service to update with :{}",dto);
        Comment comment = commentDao.findById(dto.getId(), Comment.class).get();
        if (comment.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        comment = modelMap.map(dto, Comment.class);
        commentDao.update(comment);
    }

    @Override
    public void delete(Integer id) throws ResultException {
            log.info(" start service to delete with :{}",id);
            Comment comment = commentDao.findById(id, Comment.class).get();
            if (comment.getId() == null) {
                throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
            }
            commentDao.delete(comment);
    }

    @Override
    public CommentDTO findById(Integer id) {
                Comment comment = commentDao.findById(id, Comment.class).get();
                CommentDTO dto = modelMap.map(comment, CommentDTO.class);
                return dto;
    }
}
