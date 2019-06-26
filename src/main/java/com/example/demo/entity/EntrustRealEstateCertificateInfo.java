package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 我的不动产证资料识别出来的信息表
 */
@Data
@Entity
@Table(name = "entrustRealEstateCertificateInfo")
@NoArgsConstructor
public class EntrustRealEstateCertificateInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "entrustRealEstateCertificateInfoId")
	private Integer entrustRealEstateCertificateInfoId;

	@Column(name = "entrustRealEstateCertificateId",columnDefinition = "int(11) not null")
	private Integer entrustRealEstateCertificateId;//委托不动产证资料主键id

}


