package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

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
}
