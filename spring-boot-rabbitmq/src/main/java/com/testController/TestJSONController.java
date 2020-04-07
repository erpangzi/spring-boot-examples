package com.testController;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/testJSONController")
public class TestJSONController {

    @RequestMapping(value = "/getJSONDataGet01", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String getJSONDataGet01(@RequestParam String string){
        System.out.println(string);

        return string;
    }

    @RequestMapping(value = "/getJSONDataGet", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String getJSONDataGet(@RequestBody String string){
        System.out.println(string);

        return string;
    }

    @RequestMapping(value = "/getJSONList", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public List<String> getJSONDataPOST(@RequestBody List<String> stringlist){
        String s = JSONObject.toJSONString(stringlist);
        System.out.println(s);
        return stringlist;
    }

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

    //请求？后边数据, form-data
    @ResponseBody
    @RequestMapping(value = "/getData", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public String getData(@RequestParam(name = "string") String string ,@RequestParam(name = "string01") String string01){
        System.out.println(string);
        System.out.println(string01);
        return string;
    }

    //请求testJSONController/getID/111
    @ResponseBody
    @RequestMapping(value = "/getID/{id}", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public String getID(@PathVariable(name = "id") String id){
        System.out.println(id);
        return id;
    }

    //请求form-data(body里)
    @RequestMapping(value = "/getFormData", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public String getFormData(@RequestParam("string")  String string){
        System.out.println(string);
        return string;
    }

    //请求多种参数,/{id},params(？后数据),Body Json
    @RequestMapping(value = "/getMoreData/{id}", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public String getMoreData(@PathVariable(name = "id") String id ,@RequestParam("string") String string, @RequestBody String datas){
        System.out.println(id);
        System.out.println(string);
        JSONObject jsonObject = JSONObject.parseObject(datas);
        System.out.println(jsonObject.toJSONString());
        return datas;
    }

}
