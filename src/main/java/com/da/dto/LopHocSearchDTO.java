package com.da.dto;


import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LopHocSearchDTO extends BaseSearch{
	private String id;

	private String maLop;
	
	private String tenLop;
	
	private String tenMonHoc;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date ngayKhaiGiang;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date ngayKetThuc;
	
	private Integer siSo;

	private String diaDiem;

	private Float hocPhi;

	private Date startDate;

	private Date endDate;

	private String kipDay;

	private String thu;

	private Time gioBatDau;

	private Time gioKetThuc;

	private Float diemMieng;

	private Float diem15p;

	private Float diem90p;

	private Float diemTB;
}
