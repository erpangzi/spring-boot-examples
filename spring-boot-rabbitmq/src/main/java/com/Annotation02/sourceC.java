package com.Annotation02;

import com.rabbit.model.User;
import org.springframework.web.bind.annotation.*;


@RestController
public class sourceC {
    @MyLog
    @GetMapping(value = "/sourceC/{source_name}",produces = "application/json;charset=UTF-8")
    public String sourceC(@PathVariable("source_name") String sourceName) {
        System.out.println("你正在访问sourceC资源");
        return "你正在访问sourceC资源";
    }

    @MyLog
    @PostMapping(value = "/sourceUser", produces = "application/json;charset=UTF-8")
    public User sourceUser(@RequestBody User user) {
        System.out.println("你正在访问sourceUser资源");
        return user;
    }
}