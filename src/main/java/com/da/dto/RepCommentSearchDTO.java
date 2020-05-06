package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RepCommentSearchDTO extends BaseSearch{
    private Integer id;

    private String maRepcomment;

    private String noidung;

    private Integer luotthich;

    private Integer luotkhongthich;

    private String maComment;
}
