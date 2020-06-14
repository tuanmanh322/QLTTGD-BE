package com.da.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class DocumentDTO {
    private Integer id;

    private String title;

    private String noidung;

    private LocalDateTime createdDate;

    private String linkDownload;

    private MultipartFile fileDocument;

    private Integer idThe;
}
