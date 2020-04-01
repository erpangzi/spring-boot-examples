package com.Annotation02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class sourceC {
    @MyLog
    @GetMapping(value = "/sourceC/{source_name}",produces = "application/json;charset=UTF-8")
    public String sourceC(@PathVariable("source_name") String sourceName) {
        System.out.println("你正在访问sourceC资源");
        return "你正在访问sourceC资源";
    }
}