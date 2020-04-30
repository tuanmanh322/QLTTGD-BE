package com.da.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LopHocDTO {
	private Integer id;
	
private String maLop;
	
	private String tenLop;
	
	private Date ngayKhaiGiang;
	
	private Date ngayKetThuc;
	
	private Integer siSo;
	
	private String diaDiem;
	
	private Float hocPhi;
}
