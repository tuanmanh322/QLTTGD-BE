package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
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

    private List<RepCommentDTO> repCommentDTOS;
   // private  String maMaiviet;
    private String imageAvatarCM;
}
