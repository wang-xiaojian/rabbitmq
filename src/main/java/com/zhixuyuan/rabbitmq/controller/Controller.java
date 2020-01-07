package com.zhixuyuan.rabbitmq.controller;

import com.zhixuyuan.rabbitmq.producer.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Classname Controller
 * @Description TODO
 * @Date 2020/1/7 14:41
 * @Created by 王金宝
 */
@RestController
@RequestMapping("/test")
public class Controller {


//    @ApiOperation(value = "接口的功能介绍", notes = "提示接口使用者注意事项", httpMethod = "GET")
//    @ApiImplicitParam(dataType = "string", name = "name", value = "姓名", required = true)
    @Autowired
    HelloSender helloSender;
    @GetMapping
    public String index() {
        helloSender.send();
        return "hello";
    }
}
