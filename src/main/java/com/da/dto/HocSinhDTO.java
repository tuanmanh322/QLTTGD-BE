package com.da.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
@ToString
public class HocSinhDTO extends BaseSearch {
    private Integer id;

    private String maHocSinh;

    private String Name;

    private String gioitinh;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String NgaySinh;

    private String socmt;

    private String sodt;

    private Integer maLop;

    private Integer  oldMaLop;

    private String tenLop;

    private String maThe;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String thoiGianBatDau;

    private String hocsinhName;

    private String soThe;

    private MultipartFile imageHS;

    private String tenhocsinh;

    private String email;

    private String diachi;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String sex;
}
