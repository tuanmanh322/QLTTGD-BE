package com.da.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LopHocDTO {
	private Integer id;

	private String maLop;

	private String tenlop;

	private Integer siso;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date thoigianbatdau;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date thoigianketthuc;

	private String diadiem;

	private BigDecimal hocphi;

	private String maMonhoc;

}
