package com.da.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class BaiVietDTO {
    private Integer id;

    private String mabaiviet;

    private String noidung;

    private String title;

    private Integer luotthich;

    private Integer luotkhongthich;

    private Integer idCD;

    private String chuDe;

    private Integer idUser;

    private String userName;

    private String imageAvatar;

    private Integer totalComment;

    private String imageBV;

//    @JsonFormat
    private LocalDate createDate;

//    @JsonFormat
    private Long dateMili;

    private Integer viewCounts;

    private List<CommentDTO> commentDTOS;


}
