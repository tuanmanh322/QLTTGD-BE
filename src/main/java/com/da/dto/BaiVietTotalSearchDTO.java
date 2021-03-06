package com.da.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
public class BaiVietTotalSearchDTO extends BaseSearch {
    private Integer idBV;

    private String maBV;

    private String noidungBV;

    private String titleBV;

    private Integer luotthich;

    private Integer luotkhongthich;

    private Integer idTheBV;

    private Integer idThe;

    private String maChuDe;

    private String tenchude;

    private Integer idChuDe;

    private LocalDate createDate;

    private String imageBV;

    private String imageUser;

    private Integer idUser;

    private String nameUser;

    private Long cmCount;

    private Long rcmCount;

    private Long dateMili;

    private Date startDate;

    private Date endDate;

    private Integer viewCounts;


}
