package com.da.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "notification")
@Entity
@Data
public class Notification implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "id_the")
    private Integer idThe;

    @Column(name = "id_action")
    private Integer idAction;

    @Column(name = "is_read")
    private Integer read;

    @Column(name = "message")
    private String message;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "id_baiviet")
    private Integer idBaiViet;

    @Column(name = "id_comment")
    private Integer idComment;

    @Column(name = "id_rep_comment")
    private Integer idRepComment;
}
