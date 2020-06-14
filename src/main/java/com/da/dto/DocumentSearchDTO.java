package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@ToString
public class DocumentSearchDTO extends BaseSearch {
    private Integer id;

    private String title;

    private String noidung;

    private LocalDateTime createdDate;

    private String linkDownload;

    private MultipartFile fileDocument;

    private Integer idThe;

    private Date startDate;

    private Date endDate;
}
