package com.da.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

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

    private Integer idUserBV;

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

}
