package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentSearchDTO extends BaseSearch{
    private Integer id;

    private String maComment;


    private String noidung;


    private Integer luotthich;


    private Integer loutkhongthich;

    private  String maBaiviet;
}
