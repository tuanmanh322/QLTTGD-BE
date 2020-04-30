package com.da.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "MONHOC")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MonHoc {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="ma_monhoc")
    private Integer maMonHoc;
    
    @Column(name = "tenmonhoc")
    private String tenMonHoc;

}
