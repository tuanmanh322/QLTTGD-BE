package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class RepCommentDTO {
    private Integer id;

    private String maRepcomment;

    private String noidung;

    private Integer luotthich;

    private Integer luotkhongthich;

    private Integer idComment;

    private Integer idUser;

    private String userName;

    private String imageRCM;

    private String imageAvatarRCM;

//    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime repDate;

    private Long dateMiliRCM;

    private MultipartFile repFile;
}
