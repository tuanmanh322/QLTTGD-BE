package com.da.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChuDeCountDTO {
    private Integer id;

    private String maChude;

    private String tenChude;

    private Long baiVietCount;
}
