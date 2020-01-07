package com.zhixuyuan.rabbitmq.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname User
 * @Description TODO
 * @Date 2020/1/7 17:28
 * @Created by 王金宝
 */
@Data
public class User implements Serializable {

    private String username;

    private String password;
}
