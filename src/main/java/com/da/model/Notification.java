package com.da.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "notification")
@Entity
@Getter
@Setter
@ToString
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

    @Column(name = "read")
    private Boolean read;

    @Column(name = "message")
    private String message;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public Notification() {
    }

    public Notification(Integer idThe, Integer idAction, Boolean read, String message, LocalDateTime createdDate) {
        this.idThe = idThe;
        this.idAction = idAction;
        this.read = false;
        this.message = message;
        this.createdDate = createdDate;
    }
}
