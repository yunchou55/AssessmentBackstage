package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 登录表
 */
@Entity
@Table(name = "login")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;
    //@Column（name = "自定义字段名"，length = "11"，nullable = "是否可以空"，
    // unique = "是否唯一"，columnDefinition = "自定义该字段的类型和长度"）

    @Id
    //声明"auto_increment" 来指定主键自增长
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) not null",name = "loginId")
    private Integer loginId;//用户id   (主键)

    @Column(columnDefinition = "varchar(30) not null",name = "weChatId")
    private String weChatId;//微信id

    @Column(columnDefinition = "varchar(50) not null",name = "cpuId")
    private String cpuId;//机器识别码id

    @Column(columnDefinition = "varchar(30) not null",name = "fingerId")
    private String fingerId;//指纹id

}
