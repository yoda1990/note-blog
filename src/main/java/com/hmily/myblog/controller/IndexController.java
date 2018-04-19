package com.hmily.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zyzhmily on 2018/2/2.
 */
@Controller
public class IndexController {


    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        //map.addAttribute("host", "http://blog.didispace.com");
        map.addAttribute("info", "user/list");
        // return模板文件的名称，对应src/main/resources/template/index.html.html.html
        return "index";
    }

}
