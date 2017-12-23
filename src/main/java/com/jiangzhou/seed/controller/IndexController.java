package com.jiangzhou.seed.controller;

import com.jiangzhou.seed.core.Result;
import com.jiangzhou.seed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    @ResponseBody
    Result test() {
        return userService.test();
    }
    @RequestMapping("/page")
    @ResponseBody
    Result test2() {
        return userService.test2();
    }

    @RequestMapping("/insert")
    @ResponseBody
    Result insert() {
        return userService.insert();
    }

    @RequestMapping("/join")
    @ResponseBody
    Result test3() {
        return userService.test3();
    }


}
