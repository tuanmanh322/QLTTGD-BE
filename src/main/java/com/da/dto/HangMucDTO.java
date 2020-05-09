package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

@Getter
@Setter
@ToString
public class HangMucDTO {

    private Integer id;

    private String maHangmucbaiviet;

    private String tenhangmuc;

    private String mota;

    private String maMonhoc;
}
