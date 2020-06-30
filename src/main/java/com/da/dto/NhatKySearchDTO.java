package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
public class NhatKySearchDTO extends BaseSearch {
    private Integer idThe;

    private String userName;

    private String tenLop;

    private String maThe;

    private Date tuNgay;

    private Date denNgay;

    private LocalDateTime ngayCheckIn;
}
