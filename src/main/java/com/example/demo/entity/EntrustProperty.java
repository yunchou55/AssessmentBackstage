package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 委托资产表
 */
@Data
@Entity
@Table(name = "entrustProperty")
@NoArgsConstructor
public class EntrustProperty {
    // 委托资产的id 生成的规律
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entrustPropertyId",columnDefinition = "int(11) not null")
    private int entrustPropertyId;//委托资产表主键id

    @Column(name = "entrustId",columnDefinition = "int(11) not null")
    private Integer entrustId;//委托复合表id

    //资产所在地
    @Column(name = "propertyAddress",columnDefinition = "varchar(30) not null")
    private String propertyAddress;

    //权属人身份证id
    @Column(name = "idCardId",columnDefinition = "char(16) not null")
    private String idCardId;//身份证号表的id

    //营业执照id 为
    @Column(name = "businessLicenseId",columnDefinition = "int(11) not null")
    private Integer businessLicenseId;

    //小区项目名
    @Column(name = "communityProjectName",columnDefinition = "varchar(30) not null")
    private String communityProjectName;

    //房屋用途
    @Column(name = "houseUse",columnDefinition = "varchar(50) not null")
    private String houseUse;

	//土地用途
	@Column(name = "landUse",columnDefinition = "varchar(50) not null")
	private String landUse;

	//建筑面积
	@Column(name = "buildingArea",columnDefinition = "decimal(10,2) not null")
	private BigDecimal buildingArea;

	//容积率
	@Column(name = "plotRatio",columnDefinition = "decimal(10,2) not null")
	private BigDecimal plotRatio;

	//用地面积
	@Column(name = "landUseArea",columnDefinition = "decimal(10,2) not null")
	private BigDecimal landUseArea;

	//土地年限
	@Column(name = "landAge",columnDefinition = "int(11) not null")
	private Integer landAge;

}
