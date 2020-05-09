package com.da.service.impl;

import com.da.dao.RepCommentDAO;
import com.da.dto.CommentDTO;
import com.da.dto.RepCommentDTO;
import com.da.dto.RepCommentSearchDTO;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.Comment;
import com.da.model.Repcomment;
import com.da.service.RepCommentService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
    public class RepCommentServiceImpl implements RepCommentService {
        private final Logger log = LoggerFactory.getLogger(com.da.service.impl.RepCommentServiceImpl.class);

        private final ModelMapper modelMap;

        private final RepCommentDAO repCommentDao;

        public RepCommentServiceImpl(ModelMapper modelMap, RepCommentDAO repCommentDao) {
            super();
            this.modelMap = modelMap;
            this.repCommentDao = repCommentDao;
        }

    @Override
    public void searchRepComment(RepCommentSearchDTO dto) {
        log.info(" start service to searchLopHoc with :{}",dto);
        repCommentDao.searchRepComment(dto);
    }

    @Override
    public void add(RepCommentDTO dto) throws ResultException {
        log.info(" start service to searchrepcomment with :{}",dto);
        Repcomment repcomment = modelMap.map(dto, Repcomment.class);
        repCommentDao.save(repcomment);
    }

    @Override
    public void update(RepCommentDTO dto) throws ResultException {
        log.info(" start service to update with :{}",dto);
        Repcomment repcomment = repCommentDao.findById(dto.getId(), Repcomment.class).get();
        if (repcomment.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        repcomment = modelMap.map(dto, Repcomment.class);
        repCommentDao.update(repcomment);
    }

    @Override
    public void delete(Integer id) throws ResultException {
        log.info(" start service to delete with :{}",id);
        Repcomment repcomment = repCommentDao.findById(id, Repcomment.class).get();
        if (repcomment.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        repCommentDao.delete(repcomment);
    }

    @Override
    public RepCommentDTO findById(Integer id) {
        Repcomment repcomment = repCommentDao.findById(id, Repcomment.class).get();
        RepCommentDTO dto = modelMap.map(repcomment, RepCommentDTO.class);
        return dto;
    }
}
