package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 委托不动产证表
 */
@Data
@Entity
@Table(name = "entrustRealEstateCertificate")
@NoArgsConstructor
public class EntrustRealEstateCertificate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "entrustRealEstateCertificateId")
	private Integer entrustRealEstateCertificateId;

	// 委托资产表id
	@Column(name = "entrustPropertyId",columnDefinition = "int(11) not null")
	private Integer entrustPropertyId;

	// 资产类型
	@Column(name = "type",columnDefinition = "varchar(20) not null")
	private String type;

	// 资产图片链接
	@Column(name = "imageSrc",columnDefinition = "varchar(60) not null")
	private String imageSrc;

	// 是否识别资产资料  0 or 1
	@Column(name = "isRecognized",columnDefinition = "int(11) not null")
	private Integer isRecognized;
}
