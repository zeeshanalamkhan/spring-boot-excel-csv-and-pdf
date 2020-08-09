package com.zeeshan.ecp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ven_tab")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vid")
	private Integer venId;

	@Column(name = "vcode", length = 8)
	private String venCode;

	@Column(name = "vname", length = 8)
	private String venName;

	@Column(name = "vtype", length = 8)
	private String venType;

	@Column(name = "vaddr", length = 10)
	private String addr;

	@Column(name = "vidtype", length = 10)
	private String idType;

	@Column(name = "vidnum", length = 8)
	private String idNum;

	@Column(name = "vdesc", length = 8)
	private String desc;

}
