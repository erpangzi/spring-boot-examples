package com.testController;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/testJSONController")
public class TestJSONController {

    //请求body为JSON数据
    @ResponseBody
    @RequestMapping(value = "/getJSONData", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public String getJSONData(@RequestBody String string){
        System.out.println(string);
        JSONObject jsonObject = JSONObject.parseObject(string);
        System.out.println(jsonObject.toJSONString());
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.get("datas").toString());
        return string;
    }

    //请求？后边数据
    @RequestMapping(value = "/getData", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public String getData(@RequestParam(name = "string") String string){
        System.out.println(string);
        return string;
    }

    //请求testJSONController/getID/111
    @RequestMapping(value = "/getID/{id}", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public String getID(@PathVariable(name = "id") String id){
        System.out.println(id);
        return id;
    }

    //请求form-data
    @RequestMapping(value = "/getFormData", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public String getFormData( String string){
        System.out.println(string);
        return string;
    }

    //请求多种参数
    @ResponseBody
    @RequestMapping(value = "/getMoreData/{id}", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public String getMoreData(@PathVariable(name = "id") String id ,@RequestParam("string") String string, @RequestBody String datas){
        System.out.println(id);
        System.out.println(string);
        System.out.println(datas);
        return datas;
    }

}
