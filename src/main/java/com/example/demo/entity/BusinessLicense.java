package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 营业执照表
 */
@Data
@Entity
@Table(name = "businessLicense")
@NoArgsConstructor
public class BusinessLicense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "businessLicenseId",columnDefinition = "int(11) not null")
	private Integer businessLicenseId;//营业执照表主键id

	//营业执照照片路径
	@Column(name = "image",columnDefinition = "varchar(60) not null")
	private String image;
}
