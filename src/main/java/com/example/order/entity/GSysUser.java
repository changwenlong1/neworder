package com.example.order.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GSysUser implements Serializable {

    private Long userId;

    private String loginName;

    private String password;

    private String status;

    private Date createTime;

    private Date pwdUptTime;

    private Date lastLoginTime;

    private String wechatOpenid;

    private String role;

    private String token;

}