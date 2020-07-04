package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class BaiVietSearchDTO extends BaseSearch {
    private String id;

    private String mabaiviet;

    private String titleBV;

    private String noidung;

    private Integer luotthich;

    private Integer luotkhongthich;

    private String username;

    private String maThe;

    private Integer active;

    private Date createDate;

    private String tenChuDe;
}
