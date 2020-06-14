package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "document")
public class Document implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "noidung")
    private String noidung;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "link_download")
    private String linkDownload;

    @Column(name = "id_the")
    private Integer idThe;
}
