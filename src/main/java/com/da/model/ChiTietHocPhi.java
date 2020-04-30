package com.da.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CHITIETHOCPHI")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ChiTietHocPhi {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tenhocphi")
    private String tenHocPhi;

    @Column(name = "giatien")
    private Float giaTien;

    @Column(name = "ngaythu")
    private Date ngayThu;

    @Column(name = "trangthai")
    private Boolean trangThai;

    @Column(name = "id_user")
    private Integer idUser;

}
