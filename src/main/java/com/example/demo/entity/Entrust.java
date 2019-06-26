package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 委托复合表
 */
@Entity
@Table(name = "entrust")
@Data
@NoArgsConstructor
public class Entrust implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增长
	@Column(name = "entrustId",columnDefinition = "int(11) not null")
	private Integer entrustId;//委托复合表id

	@Column(columnDefinition = "int(1) not null",name = "type")
	private Integer type;//委托形式——简单：0  ， 复杂：1

	@Column(columnDefinition = "int(11) not null",name = "necessaryId")
	private Integer necessaryId;//委托必要表的主键Id

	@Column(columnDefinition = "int(11) not null",name = "noNecessaryId")
	private Integer noNecessaryId;//委托不必要表的主键Id

	@Column(columnDefinition = "int(11) not null",name = "state")
	private Integer state;//委托状态——发布中：0  ，执行中：1  ， 已完成：2  ，  异常：3

}
