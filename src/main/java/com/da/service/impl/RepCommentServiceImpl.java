package com.da.service.impl;

import com.da.common.Constant;
import com.da.dao.RepCommentDAO;
import com.da.dto.RepCommentDTO;
import com.da.dto.RepCommentSearchDTO;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.Actions;
import com.da.model.Comment;
import com.da.model.Notification;
import com.da.model.Repcomment;
import com.da.repository.ActionsRepository;
import com.da.repository.CommentRepository;
import com.da.repository.NotificationRepository;
import com.da.security.SecurityUtils;
import com.da.service.FileStorageService;
import com.da.service.RepCommentService;
import com.da.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MimeTypeUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class RepCommentServiceImpl implements RepCommentService {
    private final Logger log = LoggerFactory.getLogger(com.da.service.impl.RepCommentServiceImpl.class);

    private final ModelMapper modelMap;

    private final RepCommentDAO repCommentDao;

    private final CommentRepository commentRepository;

    private final FileStorageService fileStorageService;

    private final NotificationRepository notificationRepository;

    private final ActionsRepository actionsRepository;

    private final UserService userService;

    private final SimpMessagingTemplate simpMessagingTemplate;

    public RepCommentServiceImpl(ModelMapper modelMap, RepCommentDAO repCommentDao, CommentRepository commentRepository, FileStorageService fileStorageService, NotificationRepository notificationRepository, ActionsRepository actionsRepository, UserService userService, SimpMessagingTemplate simpMessagingTemplate) {
        this.modelMap = modelMap;
        this.repCommentDao = repCommentDao;
        this.commentRepository = commentRepository;
        this.fileStorageService = fileStorageService;
        this.notificationRepository = notificationRepository;
        this.actionsRepository = actionsRepository;
        this.userService = userService;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @Override
    public void searchRepComment(RepCommentSearchDTO dto) {
        log.info(" start service to searchLopHoc with :{}", dto);
        repCommentDao.searchRepComment(dto);
    }

    @Override
    public void add(RepCommentDTO dto) throws ResultException {
        log.info(" start service to searchrepcomment with :{}", dto);
        Repcomment repcomment = modelMap.map(dto, Repcomment.class);
        repCommentDao.save(repcomment);
    }

    @Override
    public void update(RepCommentDTO dto) throws ResultException {
        log.info(" start service to update with :{}", dto);
        Repcomment repcomment = repCommentDao.findById(dto.getId(), Repcomment.class).get();
        if (repcomment.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        repcomment = modelMap.map(dto, Repcomment.class);
        repCommentDao.update(repcomment);
    }

    @Override
    public void delete(Integer id) throws ResultException {
        log.info(" start service to delete with :{}", id);
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

    @Override
    public boolean repcomment(Integer idComment, RepCommentDTO repCommentDTO) {
        log.info(" start service to repcomment with idCM:{} and dto : {}", idComment, repCommentDTO);
        Optional<Comment> comment = commentRepository.findById(idComment);
        if (comment.isPresent()) {
            Repcomment repcomment = new Repcomment();
            repcomment.setIdComment(comment.get().getId());
            repcomment.setRepDate(LocalDateTime.now());
            repcomment.setIdUser(SecurityUtils.getCurrentUserIdLogin());
            repcomment.setNoidung(repCommentDTO.getNoidung());
            if (repCommentDTO.getRepFile() != null) {
                try {
                    repcomment.setImageRCM(fileStorageService.storeFile(repCommentDTO.getRepFile()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            repCommentDao.save(repcomment);
            Notification notifycation = new Notification();
            notifycation.setIdAction(Constant.REPCOMMENT);
            Optional<Actions> actions = actionsRepository.findById(Constant.REPCOMMENT);
            actions.ifPresent(ac -> notifycation.setMessage(ac.getStatuss()));
            notifycation.setIdThe(SecurityUtils.getCurrentUserIdLogin());
            notifycation.setCreatedDate(LocalDateTime.now());
            notificationRepository.save(notifycation);
            /*
             * This block is used to
             * send the notification the
             * users for whom, the event was
             * generated.
             */
            SimpMessageHeaderAccessor simpMessageHeaderAccessor = SimpMessageHeaderAccessor.create();
            simpMessageHeaderAccessor.setContentType(MimeTypeUtils.APPLICATION_JSON);
            simpMessageHeaderAccessor.setLeaveMutable(true);
            MessageHeaders messageHeaders = simpMessageHeaderAccessor.getMessageHeaders();
            simpMessagingTemplate.convertAndSendToUser(userService.getUserNameLogin(),"/api/feed", notifycation.getMessage(),messageHeaders);
            return true;
        }
        return false;
    }
}
