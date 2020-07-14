package com.da.service.impl;

import com.da.common.Constant;
import com.da.dao.CommentDAO;
import com.da.dto.CommentDTO;
import com.da.dto.CommentSearchDTO;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.Actions;
import com.da.model.Comment;
import com.da.model.Notification;
import com.da.repository.ActionsRepository;
import com.da.repository.CommentRepository;
import com.da.repository.NotificationRepository;
import com.da.security.SecurityUtils;
import com.da.service.CommentService;
import com.da.service.FileStorageService;
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
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private final Logger log = LoggerFactory.getLogger(HangMucServiceImpl.class);

    private final ModelMapper modelMap;

    private final CommentDAO commentDao;

    private final FileStorageService fileStorageService;

    private final NotificationRepository notificationRepository;

    private final ActionsRepository actionsRepository;

    private final UserService userService;

    private final SimpMessagingTemplate simpMessagingTemplate;

    private final CommentRepository commentRepository;


    public CommentServiceImpl(ModelMapper modelMap, CommentDAO commentDao, FileStorageService fileStorageService, NotificationRepository notificationRepository, ActionsRepository actionsRepository, UserService userService, SimpMessagingTemplate simpMessagingTemplate, CommentRepository commentRepository) {
        this.modelMap = modelMap;
        this.commentDao = commentDao;
        this.fileStorageService = fileStorageService;
        this.notificationRepository = notificationRepository;
        this.actionsRepository = actionsRepository;
        this.userService = userService;
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.commentRepository = commentRepository;
    }

    @Override
    public void searchComment(CommentSearchDTO dto) {
        log.info(" start service to searchHangMuc with :{}", dto);
        commentDao.searchComment(dto);
    }

    @Override
    public void add(CommentDTO dto) throws ResultException {
        log.info(" start service to searchChuDe with :{}", dto);
        Comment comment = modelMap.map(dto, Comment.class);
        comment.setIdUser(SecurityUtils.getCurrentUserIdLogin());
        comment.setLuotthich(0);
        comment.setLoutkhongthich(0);
        commentDao.save(comment);
    }

    @Override
    public void update(CommentDTO dto) throws ResultException {
        log.info(" start service to update with :{}", dto);
        Comment comment = commentDao.findById(dto.getId(), Comment.class).get();
        if (comment.getId() == null) {
            throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
        }
        comment = modelMap.map(dto, Comment.class);
        commentDao.update(comment);
    }

    @Override
    public void delete(Integer id) throws ResultException {
        log.info(" start service to delete with :{}", id);
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

    @Override
    public boolean isCommentBV(Integer idBV, CommentDTO commentDTO) {
        log.info(" start service to isCommentBV with id :{} and dto : {}", idBV, commentDTO);

        if (idBV != null) {
            Comment comment = new Comment();
            comment.setIdBaiViet(idBV);
            comment.setIdUser(SecurityUtils.getCurrentUserIdLogin());
            if (commentDTO.getFileCM() != null) {
                try {
                    comment.setImageCM(fileStorageService.storeFile(commentDTO.getFileCM()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            comment.setCommentDate(LocalDateTime.now());
            comment.setNoidung(commentDTO.getNoiDung());
            commentDao.save(comment);
            Notification notifycation = new Notification();
            notifycation.setCreatedDate(LocalDateTime.now());
            notifycation.setIdAction(Constant.COMMENT);
            notifycation.setIdThe(SecurityUtils.getCurrentUserIdLogin());
            notifycation.setRead(0);
            notifycation.setIdBaiViet(idBV);
            Optional<Actions> actions = actionsRepository.findById(Constant.COMMENT);
            actions.ifPresent(ac -> notifycation.setMessage(ac.getStatuss()));
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
            simpMessagingTemplate.convertAndSendToUser(userService.getUserNameLogin(), "/queue/feed", notifycation.getMessage(), messageHeaders);
            return true;
        }
        return false;
    }

    @Override
    public boolean isLikeCM(CommentDTO commentDTO) {
        Comment comment = commentRepository.getOne(commentDTO.getId());
        if (comment != null) {
            comment.setLuotthich(commentDTO.getLuotThich());
            commentRepository.save(comment);

            Notification notification = new Notification();
            notification.setRead(0);
            notification.setIdBaiViet(commentDTO.getIdBaiViet());
            notification.setIdComment(comment.getId());
            notification.setIdThe(SecurityUtils.getCurrentUserIdLogin());
            notification.setIdAction(Constant.LIKE_COMMENT);
            notification.setCreatedDate(LocalDateTime.now());
            notification.setMessage(Constant.LIKECM);
            notificationRepository.save(notification);
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
            simpMessagingTemplate.convertAndSendToUser(userService.getUserNameLogin(), "/queue/feed", notification.getMessage(), messageHeaders);
            return true;
        }
        return false;
    }

    @Override
    public boolean isDisLikeCM(CommentDTO commentDTO) {
        Comment comment = commentRepository.getOne(commentDTO.getId());
        if (comment != null) {
            comment.setLoutkhongthich(commentDTO.getLuotKhongthich());
            commentRepository.save(comment);

            Notification notification = new Notification();
            notification.setRead(0);
            notification.setIdBaiViet(commentDTO.getIdBaiViet());
            notification.setIdComment(comment.getId());
            notification.setIdThe(SecurityUtils.getCurrentUserIdLogin());
            notification.setIdAction(Constant.DISLIKE_COMMENT);
            notification.setCreatedDate(LocalDateTime.now());
            notification.setMessage(Constant.DISLIKECM);
            notificationRepository.save(notification);
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
            simpMessagingTemplate.convertAndSendToUser(userService.getUserNameLogin(), "/queue/feed", notification.getMessage(), messageHeaders);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkLikeCM(int idCM, int idBV) {
        List<Notification> notifications = notificationRepository.checkAlreadyLikeCM(SecurityUtils.getCurrentUserIdLogin(), idBV, idCM);
        return notifications.size() > 0;
    }

    @Override
    public boolean checkDisLikeCM(int idCM, int idBV) {
        List<Notification> notifications = notificationRepository.checkAlreadyDisLikeCM(SecurityUtils.getCurrentUserIdLogin(), idBV, idCM);
        return notifications.size() > 0;
    }
}
