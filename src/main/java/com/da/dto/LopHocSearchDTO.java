package com.da.dto;


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

}
