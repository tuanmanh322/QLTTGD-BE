package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaiVietSearchDTO extends BaseSearch {
    private String id;

    private String mabaiviet;

    private String noidung;

    private Integer luotthich;

    private Integer luotkhongthich;
}
