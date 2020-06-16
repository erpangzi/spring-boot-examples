package com.ListennerFilterInterceptor;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController("/LFI")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${application.message:Hello World}")
    private String message ;

    @GetMapping("/asd/{name}")
    public String welcome(@PathVariable String name,Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "welcome111";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Object foo() {
        logger.info("打印日志----------------------");
        return  "login";
    }

    @RequestMapping("/index")
    @ResponseBody
    public Object index(HttpServletRequest request) {
        HttpSession  session = request.getSession(true);
        session.setAttribute("zxc", "zxc");
        return  "index";
    }

    @RequestMapping("/index1")
    @ResponseBody
    public Object index1(HttpServletRequest request) {
        HttpSession  session = request.getSession(true);
        session.setAttribute("zxc1", "zxc1");
        return  "index1";
    }

    @RequestMapping("/indexDestroyed")
    @ResponseBody
    public Object indexDestroyed(HttpServletRequest request) {
        HttpSession  session = request.getSession(true);
        session.removeAttribute("zxc");
        session.invalidate();
        return  "indexDestroyed";
    }

    @RequestMapping("/online")
    @ResponseBody
    public Object online() {
        return  "当前在线人数：" + MyHttpSessionListener.online + "人";
    }
}
