package com.da.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class CommentDTO {
    private Integer id;

    private String maComment;


    private String noiDung;


    private Integer luotThich;


    private Integer luotKhongthich;

    private Integer idBaiViet;

    private Integer idUser;

    private String userName;

    private String imageCM;

    private String imageAvatarCM;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime commentDate;

    private Long dateMiliCM;
    private List<RepCommentDTO> repCommentDTOS;

    private MultipartFile fileCM;
   // private  String maMaiviet;


}
