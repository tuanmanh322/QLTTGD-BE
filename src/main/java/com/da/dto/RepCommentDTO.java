package com.da.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import java.util.Date;

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

    private String imageAvatarRCM;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date repDate;
}
