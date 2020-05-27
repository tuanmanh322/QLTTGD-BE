package com.da.service.impl;

import com.da.dao.BaiVietDAO;
import com.da.dto.BaiVietDTO;
import com.da.dto.BaiVietSearchDTO;
import com.da.dto.CommentDTO;
import com.da.dto.RepCommentDTO;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.Baiviet;
import com.da.model.Comment;
import com.da.model.Repcomment;
import com.da.model.Users;
import com.da.repository.BaivietRepository;
import com.da.repository.CommentRepository;
import com.da.repository.RepcommentRepository;
import com.da.repository.UsersRepository;
import com.da.security.SecurityUtils;
import com.da.service.BaiVietService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BaiVietServiceImpl implements BaiVietService {
    private final Logger log = LoggerFactory.getLogger(ChuDeServiceImpl.class);

    private final ModelMapper modelMap;

    private final BaiVietDAO baiVietDao;

    private final BaivietRepository baivietRepository;

    private final CommentRepository commentRepository;

    private final RepcommentRepository repcommentRepository;

    private final UsersRepository usersRepository;

    public BaiVietServiceImpl(ModelMapper modelMap, BaiVietDAO baiVietDao, BaivietRepository baivietRepository, CommentRepository commentRepository, RepcommentRepository repcommentRepository, UsersRepository usersRepository) {
        this.modelMap = modelMap;
        this.baiVietDao = baiVietDao;
        this.baivietRepository = baivietRepository;
        this.commentRepository = commentRepository;
        this.repcommentRepository = repcommentRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public void searchBaiViet(BaiVietSearchDTO dto) {
        log.info(" start service to searchChuDe with :{}", dto);
        baiVietDao.searchBaiViet(dto);
    }

    @Override
    public void add(BaiVietDTO dto) throws ResultException {
        log.info(" start service to searchChuDe with :{}", dto);
        Baiviet baiviet = modelMap.map(dto, Baiviet.class);
        baiviet.setIdUser(SecurityUtils.getCurrentUserIdLogin());
        baiVietDao.save(dto);

    }

    @Override
    public void update(BaiVietDTO dto) throws ResultException {
        log.info(" start service to update with :{}", dto);
        Baiviet baiviet = baiVietDao.findById(dto.getId(), Baiviet.class).get();
        if (baiviet.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        baiviet = modelMap.map(dto, Baiviet.class);
        baiVietDao.update(baiviet);
    }

    @Override
    public void delete(Integer id) throws ResultException {
        log.info(" start service to update with :{}", id);
        Baiviet baiviet = baiVietDao.findById(id, Baiviet.class).get();
        if (baiviet.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        baiVietDao.delete(baiviet);
    }

    @Override
    public BaiVietDTO findById(Integer id) {
        Baiviet baiviet = baiVietDao.findById(id, Baiviet.class).get();
        BaiVietDTO dto = modelMap.map(baiviet, BaiVietDTO.class);
        return dto;
    }

    @Override
    public List<BaiVietDTO> getBaiVietWithComment() {
        log.info("start service to get getBaiVietWithComment");
        List<Baiviet> baiviets = baivietRepository.findAll();
        List<BaiVietDTO> bvResult = new ArrayList<>();
        BaiVietDTO baiVietDTO = new BaiVietDTO();
        List<CommentDTO> commentDTOList = new ArrayList<>();
        List<RepCommentDTO> repCommentDTOList = new ArrayList<>();
        for (Baiviet baiviet : baiviets) {
            Users users = usersRepository.findById(baiviet.getIdUser()).get();
            baiVietDTO.setUserName(users.getName());
            // get list comment by id
            List<Comment> comments = commentRepository.findByIdBaiViet(baiviet.getId());
            // add list comment
            comments.stream().map(cm -> {
                Users usersCM = usersRepository.findById(cm.getIdUser()).get();
                CommentDTO commentDTO = modelMap.map(cm, CommentDTO.class);
                commentDTO.setUserName(usersCM.getName());
                List<Repcomment> repcomments = repcommentRepository.findByIdComment(cm.getId());
                // add list repcomment
                repcomments.stream().map(rep -> {
                    Users usersRCM = usersRepository.findById(rep.getIdUser()).get();
                    RepCommentDTO repCommentDTO = modelMap.map(rep, RepCommentDTO.class);
                    repCommentDTO.setUserName(usersRCM.getName());
                    repCommentDTOList.add(repCommentDTO);
                    return repCommentDTOList;
                }).collect(Collectors.toList());
                commentDTO.setRepCommentDTOS(repCommentDTOList);
                commentDTOList.add(commentDTO);
                return commentDTOList;
            }).collect(Collectors.toList());
            baiVietDTO = modelMap.map(baiviet, BaiVietDTO.class);
            baiVietDTO.setCommentDTOS(commentDTOList);
            bvResult.add(baiVietDTO);
        }
        return bvResult;
    }

    @Override
    public BaiVietDTO getDetailBVCMREM(Integer idBV) {
        log.info("start service to get getDetailBVCMREM with idBV: {}", idBV);
        Baiviet baiviets = baivietRepository.findById(idBV).get();
        Users users = usersRepository.findById(baiviets.getIdUser()).get();
        BaiVietDTO baiVietDTO = modelMap.map(baiviets, BaiVietDTO.class);
        baiVietDTO.setUserName(users.getName());
        List<CommentDTO> commentDTOList = new ArrayList<>();
        List<RepCommentDTO> repCommentDTOList = new ArrayList<>();
        // get list comment by id
        List<Comment> comments = commentRepository.findByIdBaiViet(baiviets.getId());
        // add list comment
        comments.stream().map(cm -> {
            Users usersCM = usersRepository.findById(cm.getIdUser()).get();
            CommentDTO commentDTO = modelMap.map(cm, CommentDTO.class);
            commentDTO.setUserName(usersCM.getName());
            List<Repcomment> repcomments = repcommentRepository.findByIdComment(cm.getId());
            // add list repcomment
            repcomments.stream().map(rep -> {
                Users usersRCM = usersRepository.findById(rep.getIdUser()).get();
                RepCommentDTO repCommentDTO = modelMap.map(rep, RepCommentDTO.class);
                repCommentDTO.setUserName(usersRCM.getName());
                repCommentDTOList.add(repCommentDTO);
                return repCommentDTOList;
            }).collect(Collectors.toList());
            commentDTO.setRepCommentDTOS(repCommentDTOList);
            commentDTOList.add(commentDTO);
            return commentDTOList;
        }).collect(Collectors.toList());
        baiVietDTO.setCommentDTOS(commentDTOList);
        return baiVietDTO;
    }
}
