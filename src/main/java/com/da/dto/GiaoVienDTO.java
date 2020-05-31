package com.da.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GiaoVienDTO extends BaseSearch{
    private Integer id;

    private String maGiaoVien;

    private String Name;

    private String GioiTinh;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String NgaySinh;

    private String socmt;

    private String sodt;

    private String maLop;

    private String tenLop;

    private String maThe;
}