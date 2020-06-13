package com.da.service.impl;

import com.da.common.Constant;
import com.da.common.Orders;
import com.da.dao.BaiVietDAO;
import com.da.dto.*;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.*;
import com.da.repository.*;
import com.da.security.SecurityUtils;
import com.da.service.BaiVietService;
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

import java.time.LocalDateTime;
import java.time.ZoneOffset;
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

    private final ChudeRepository chudeRepository;

    private final ActionsRepository actionsRepository;

    private final NotificationRepository notificationRepository;

    private final FileStorageService fileStorageService;

    private final SimpMessagingTemplate simpMessagingTemplate;

    private final UserService userService;

    public BaiVietServiceImpl(ModelMapper modelMap, BaiVietDAO baiVietDao, BaivietRepository baivietRepository, CommentRepository commentRepository, RepcommentRepository repcommentRepository, UsersRepository usersRepository, ChudeRepository chudeRepository, ActionsRepository actionsRepository, NotificationRepository notificationRepository, FileStorageService fileStorageService, SimpMessagingTemplate simpMessagingTemplate, UserService userService) {
        this.modelMap = modelMap;
        this.baiVietDao = baiVietDao;
        this.baivietRepository = baivietRepository;
        this.commentRepository = commentRepository;
        this.repcommentRepository = repcommentRepository;
        this.usersRepository = usersRepository;
        this.chudeRepository = chudeRepository;
        this.actionsRepository = actionsRepository;
        this.notificationRepository = notificationRepository;
        this.fileStorageService = fileStorageService;
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.userService = userService;
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
        baiviet.setIdThe(SecurityUtils.getCurrentUserIdLogin());
        baiviet.setMa_chude(dto.getIdCD());
        baiviet.setCreatedDate(LocalDateTime.now());
        baiVietDao.save(baiviet);

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
        List<Baiviet> baiviets = baivietRepository.findAll(Orders.DESC("created_date"));
        List<BaiVietDTO> bvResult = new ArrayList<>();

        List<CommentDTO> commentDTOList = new ArrayList<>();
        List<RepCommentDTO> repCommentDTOList = new ArrayList<>();
        for (Baiviet baiviet : baiviets) {
            BaiVietDTO baiVietDTO = new BaiVietDTO();
            Users users = usersRepository.findByMaThe(baiviet.getIdThe());
            baiVietDTO.setUserName(users.getName());
            baiVietDTO.setImageAvatar(users.getImagePath());
            baiVietDTO.setCreateDate(baiviet.getCreatedDate().toLocalDate());
            baiVietDTO.setTitle(baiviet.getTitle());
            // get list comment by id
            List<Comment> comments = commentRepository.findByIdBaiViet(baiviet.getId());
            // add list comment
            comments.stream().map(cm -> {
                Users usersCM = usersRepository.findById(cm.getIdUser()).get();
                CommentDTO commentDTO = modelMap.map(cm, CommentDTO.class);
                commentDTO.setUserName(usersCM.getName());
                commentDTO.setImageAvatarCM(usersCM.getImagePath());
                List<Repcomment> repcomments = repcommentRepository.findByIdComment(cm.getId());
                // add list repcomment
                repcomments.stream().map(rep -> {
                    Users usersRCM = usersRepository.findById(rep.getIdUser()).get();
                    RepCommentDTO repCommentDTO = modelMap.map(rep, RepCommentDTO.class);
                    repCommentDTO.setUserName(usersRCM.getName());
                    repCommentDTO.setImageAvatarRCM(usersRCM.getImagePath());
                    repCommentDTOList.add(repCommentDTO);
                    return repCommentDTOList;
                }).collect(Collectors.toList());
                commentDTO.setRepCommentDTOS(repCommentDTOList);
                commentDTOList.add(commentDTO);
                return commentDTOList;
            }).collect(Collectors.toList());
            baiVietDTO = modelMap.map(baiviet, BaiVietDTO.class);
            baiVietDTO.setTotalComment(repCommentDTOList.size() + comments.size());
            baiVietDTO.setCommentDTOS(commentDTOList);
            bvResult.add(baiVietDTO);
        }
        return bvResult;
    }

    @Override
    public List<BaiVietDTO> getBVandTotalComment() {
        log.info("start service to get getBVandTotalComment");
        List<Baiviet> baiviets = baivietRepository.findAll(Orders.DESC("createdDate"));
        List<BaiVietDTO> bvResult = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        for (Baiviet baiviet : baiviets) {
            BaiVietDTO baiVietDTO = new BaiVietDTO();
            Users users = usersRepository.findByMaThe(baiviet.getIdThe());
            baiVietDTO.setUserName(users.getName());
            baiVietDTO.setImageAvatar(users.getImagePath());
            baiVietDTO.setDateMili(baiviet.getCreatedDate().toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli());
            baiVietDTO.setCreateDate(baiviet.getCreatedDate().toLocalDate());
            baiVietDTO.setTitle(baiviet.getTitle());
            baiVietDTO.setLuotthich(baiviet.getLuotthich());
            baiVietDTO.setLuotkhongthich(baiviet.getLuotkhongthich());
            baiVietDTO.setMabaiviet(baiviet.getMaBaiviet());
            baiVietDTO.setNoidung(baiviet.getNoidung());
            baiVietDTO.setIdUser(users.getId());
            baiVietDTO.setId(baiviet.getId());
            // get list comment by id
            List<Comment> comments = commentRepository.findByIdBaiViet(baiviet.getId());
            comments.stream().map(cm -> {
                List<Repcomment> repcomments = repcommentRepository.findByIdComment(cm.getId());
                objects.addAll(repcomments);
                return repcomments.size();
            }).collect(Collectors.toList());
            baiVietDTO.setTotalComment(comments.size() + objects.size());
            bvResult.add(baiVietDTO);
        }
        return bvResult;
    }

    @Override
    public BaiVietDTO getDetailBVCMREM(Integer idBV) {
        log.info("start service to get getDetailBVCMREM with idBV: {}", idBV);
        Baiviet baiviets = baivietRepository.findById(idBV).get();

        Users users = usersRepository.findByMaThe(baiviets.getIdThe());
        BaiVietDTO baiVietDTO = modelMap.map(baiviets, BaiVietDTO.class);
        baiVietDTO.setImageBV(baiviets.getImageBV());
        baiVietDTO.setUserName(users.getName());
        baiVietDTO.setIdUser(users.getId());
        baiVietDTO.setImageAvatar(users.getImagePath());
        baiVietDTO.setDateMili(baiviets.getCreatedDate().toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli());
        baiVietDTO.setCreateDate(baiviets.getCreatedDate().toLocalDate());
        Optional<Chude> chude = chudeRepository.findById(baiviets.getMa_chude());
        if (chude.isPresent()) {
            baiVietDTO.setChuDe(chude.get().getTenChude());
            baiVietDTO.setIdCD(chude.get().getId());
        }
        List<CommentDTO> commentDTOList = new ArrayList<>();
        List<RepCommentDTO> repCommentDTOList = new ArrayList<>();
        // get list comment by id
        List<Comment> comments = commentRepository.findByIdBaiViet(baiviets.getId());
        // add list comment
        comments.stream().map(cm -> {
            Users usersCM = usersRepository.findById(cm.getIdUser()).get();
            CommentDTO commentDTO = modelMap.map(cm, CommentDTO.class);
            commentDTO.setImageCM(cm.getImageCM());
            commentDTO.setUserName(usersCM.getName());
            commentDTO.setImageAvatarCM(usersCM.getImagePath());
            commentDTO.setCommentDate(cm.getCommentDate());
            List<Repcomment> repcomments = repcommentRepository.findByIdComment(cm.getId());
            // add list repcomment
            repcomments.stream().map(rep -> {
                Users usersRCM = usersRepository.findById(rep.getIdUser()).get();
                RepCommentDTO repCommentDTO = modelMap.map(rep, RepCommentDTO.class);
                repCommentDTO.setImageRCM(rep.getImageRCM());
                repCommentDTO.setUserName(usersRCM.getName());
                repCommentDTO.setImageAvatarRCM(usersRCM.getImagePath());
                repCommentDTO.setRepDate(rep.getRepDate());
                repCommentDTOList.add(repCommentDTO);
                return repCommentDTOList;
            }).collect(Collectors.toList());
            commentDTO.setRepCommentDTOS(repCommentDTOList);
            commentDTOList.add(commentDTO);
            return commentDTOList;
        }).collect(Collectors.toList());
        baiVietDTO.setCommentDTOS(commentDTOList);
        baiVietDTO.setTotalComment(repCommentDTOList.size() + comments.size());
        return baiVietDTO;
    }

    @Override
    public List<BaiVietDTO> getAllByChuDe(Integer idChuDe) {
        log.info("start service to get getAllByChuDe");
        List<Baiviet> baiviets = baivietRepository.findByMaChuDe(idChuDe);
        Optional<Chude> chude = chudeRepository.findById(idChuDe);

        List<BaiVietDTO> bvResult = new ArrayList<>();
        List<Integer> objects = new ArrayList<>();
        for (Baiviet baiviet : baiviets) {
            BaiVietDTO baiVietDTO = new BaiVietDTO();
            Users users = usersRepository.findByMaThe(baiviet.getIdThe());
            baiVietDTO.setUserName(users.getName());
            baiVietDTO.setImageAvatar(users.getImagePath());
            baiVietDTO.setDateMili(baiviet.getCreatedDate().toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli());
            baiVietDTO.setCreateDate(baiviet.getCreatedDate().toLocalDate());
            baiVietDTO.setTitle(baiviet.getTitle());
            baiVietDTO.setLuotthich(baiviet.getLuotthich());
            baiVietDTO.setLuotkhongthich(baiviet.getLuotkhongthich());
            baiVietDTO.setMabaiviet(baiviet.getMaBaiviet());
            baiVietDTO.setNoidung(baiviet.getNoidung());
            baiVietDTO.setIdUser(users.getId());
            baiVietDTO.setId(baiviet.getId());
            baiVietDTO.setChuDe(chude.get().getTenChude());
            // get list comment by id
            List<Comment> comments = commentRepository.findByIdBaiViet(baiviet.getId());
            if (!comments.isEmpty()) {
                comments.stream().map(cm -> {
                    List<Repcomment> repcomments = repcommentRepository.findByIdComment(cm.getId());
                    if (!repcomments.isEmpty()) {
                        objects.add(repcomments.size());
                    }
                    return objects;
                }).collect(Collectors.toList());
            }
            baiVietDTO.setTotalComment(comments.size() + objects.get(0));
            bvResult.add(baiVietDTO);
        }
        return bvResult;
    }

    @Override
    public void searchBaiVietGetTotal(BaiVietTotalSearchDTO baiVietTotalSearchDTO) {
        log.info(" start service to searchBaiVietGetTotal with : {}", baiVietTotalSearchDTO);
        baiVietDao.searchBaiVietToTal(baiVietTotalSearchDTO);
    }

    @Override
    public void searchBaiVietGetTotalByIdCD(BaiVietTotalSearchDTO baiVietTotalSearchDTO, Integer idCD) {
        log.info(" start service to searchBaiVietGetTotalByIdCD with : {} and idCD: {}", baiVietTotalSearchDTO, idCD);
        baiVietDao.searchBaiVietToTalByIdCD(baiVietTotalSearchDTO, idCD);
    }

    @Override
    public boolean isLikeOrUnLikeBV(Integer idBV, BaiVietDTO baiVietDTO) {
        log.info(" start service to isLikeOrUnLikeBV with id :{} and dto : {}", idBV, baiVietDTO);
        Optional<Baiviet> baiviet = baivietRepository.findById(idBV);
        if (baiviet.isPresent()) {
            Baiviet bv = baiviet.get();
            bv.setLuotthich(baiVietDTO.getLuotthich());
            baivietRepository.save(bv);
            Notification notifycation = new Notification();
            notifycation.setCreatedDate(LocalDateTime.now());
            notifycation.setIdAction(Constant.LIKE);
            notifycation.setIdThe(SecurityUtils.getCurrentUserIdLogin());
            Optional<Actions> actions = actionsRepository.findById(Constant.LIKE);
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
            simpMessagingTemplate.convertAndSendToUser(userService.getUserNameLogin(),"/api/feed", notifycation.getMessage(),messageHeaders);
            return true;
        }
        return false;
    }

    @Override
    public boolean isDislikeOrUnDisLikeBV(Integer idBV, BaiVietDTO baiVietDTO) {
        log.info(" start service to isDislikeOrUnDisLikeBV with id :{} and dto : {}", idBV, baiVietDTO);
        Baiviet bv = findByIdModel(idBV);
        if (bv !=null){
            bv.setLuotkhongthich(baiVietDTO.getLuotkhongthich());
            baivietRepository.save(bv);
            Notification notifycation = new Notification();
            notifycation.setCreatedDate(LocalDateTime.now());
            notifycation.setIdAction(Constant.DISLIKE);
            notifycation.setIdThe(SecurityUtils.getCurrentUserIdLogin());
            Optional<Actions> actions = actionsRepository.findById(Constant.DISLIKE);
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
            simpMessagingTemplate.convertAndSendToUser(userService.getUserNameLogin(),"/api/feed", notifycation.getMessage(),messageHeaders);
            return true;
        }
        return false;
    }

    @Override
    public Baiviet findByIdModel(Integer idBV) {
        log.info(" start service to findByIdModel with id :{}  ", idBV);
        Optional<Baiviet> baiviet = baivietRepository.findById(idBV);
        return baiviet.orElse(null);
    }
}
