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
public class GiaoVienDTO extends BaseSearch{
    private Integer id;

    private String maGiaoVien;

    private String Name;

    private String GioiTinh;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date NgaySinh;

    private String socmt;

    private String sodt;

    private String maLop;

    private String tenLop;

    private String maThe;

    private String kipDay;

    private Double luongcoban;

    private Integer idLop;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private Integer cmt;

    private Integer siso;

    private String sex;

    private MultipartFile imageGV;
}
