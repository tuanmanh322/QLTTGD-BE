package com.da.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class BaiVietDTO {
    private String id;

    private String mabaiviet;

    private String noidung;

    private Integer luotthich;

    private Integer luotkhongthich;

    private Integer idUser;

    private String userName;

    private String imageAvatar;

    private Integer totalComment;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    private List<CommentDTO> commentDTOS;


}
