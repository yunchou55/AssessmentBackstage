package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 委托复合表中的必要信息表
 */
@Entity
@Table(name = "entrustNecessary")
@Data
@NoArgsConstructor
public class EntrustNecessary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增长
	@Column(columnDefinition = "int(11) not null",name = "necessaryId")
	private Integer necessaryId;//委托必要表的主键Id

	@Column(columnDefinition = "int(11) not null",name = "userId")
	private Integer userId;//委托人id

	@Column(columnDefinition = "varchar(20) not null",name = "name")
	private String name;//委托人填写的名字

	@Column(columnDefinition = "char(11) not null",name = "phone")
	private String phone;//手机号码

	@Column(columnDefinition = "varchar(25) not null",name = "company")
	private String company;//委托人填写的公司名称

	@Column(columnDefinition = "varchar(11) not null",name = "companyPhone")
	private String companyPhone;//委托人填写的公司联系方式

	@Column(columnDefinition = "decimal(10,2) not null",name = "money")
	private Double money;//路费、误餐费
}
