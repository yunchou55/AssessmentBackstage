package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户表
 */
@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    @Column(name = "userId",columnDefinition = "int(11) not null")
    private Integer userId;//用户表id

    @Column(name = "loginId",columnDefinition = "int(11) not null")
    private Integer loginId;

    @Column(name = "nickName",columnDefinition = "varchar(15) not null")
    private String nickName;//昵称

    @Column(columnDefinition = "varchar(50) not null",name = "profilePicture")
    private String profilePicture;//用户头像

    @Column(columnDefinition = "char(11) not null",name = "phone")
    private String phone;//手机号码

    @Column(columnDefinition = "varchar(30) not null",name = "email")
    private String email;//邮箱

    @Column(columnDefinition = "varchar(30) not null",name = "weChat")
    private String weChat;//微信号

}
