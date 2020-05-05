package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class HangMucSearchDTO extends BaseSearch{
    private Integer id;

    private String maHangmucbaiviet;

    private String tenhangmuc;

    private String mota;

    private String maMonhoc;

}
