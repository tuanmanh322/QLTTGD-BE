package com.da.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

@Getter
@Setter
@ToString
public class ChuDeSearchDTO extends BaseSearch{

    private String id;

    private String machude;

    private String tenchude;

    private String noidung;
}
