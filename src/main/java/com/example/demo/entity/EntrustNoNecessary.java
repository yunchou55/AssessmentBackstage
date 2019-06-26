package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 委托复合表中的不必要信息表
 */
@Entity
@Table(name = "entrustNoNecessary")
@Data
@NoArgsConstructor
public class EntrustNoNecessary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增长
	@Column(columnDefinition = "int(11) not null",name = "noNecessaryId")
	private Integer noNecessaryId;//委托必要表的主键Id

	@Column(columnDefinition = "datetime not null",name = "time")
	private Timestamp time;//上门时间

	@Column(columnDefinition = "varchar(50) not null",name = "requirement")
	private String requirement;//期限要求

	@Column(columnDefinition = "varchar(50) not null",name = "remark")
	private String remark;//备注

	@Column(columnDefinition = "int(11) not null",name = "userId")
	private Integer userId;//指定受托人

	@Column(columnDefinition = "int(11) not null",name = "companyId")
	private Integer companyId;//指定委托公司
}
