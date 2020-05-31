package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    private List<CommentDTO> commentDTOS;

    private String imageAvatar;
}
