package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class NotificationDTO {
    private Integer id;

    private Integer idThe;

    private Integer idAction;

    private Integer isRead;

    private String message;

    private LocalDateTime createdDate;

    private Integer idBaiViet;

    private Integer idCm;

    private Integer idReCm;

    private String titleBV;

    private String userName;
}
