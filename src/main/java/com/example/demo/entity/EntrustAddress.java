package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 委托上门地址表
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "entrustAddress")
public class EntrustAddress implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) not null",name = "entrustAddressId")
    private Integer entrustAddressId;//主键id

    //委托复合表id
    @Column(columnDefinition = "int(11) not null",name = "entrustId")
    private Integer entrustId;


    //委托地址
    @Column(columnDefinition = "varchar(30) not null",name = "entrustAddress")
    private String entrustAddress;




}
