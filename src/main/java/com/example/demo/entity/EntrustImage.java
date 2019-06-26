package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 委托图片表
 */
@Data
@Entity
@Table(name = "entrustImage")
@NoArgsConstructor
public class EntrustImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entrustImageId",columnDefinition = "int(11) not null")
    private Integer entrustImageId;

    @Column(name = "entrustId",columnDefinition = "int(11) not null")
    private Integer entrustId;//委托复合表id

    //图片的链接
    @Column(name = "imageSrc",columnDefinition = "varchar(100) not null")
    private String imageSrc;

}
