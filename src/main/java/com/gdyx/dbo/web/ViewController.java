package com.gdyx.dbo.web;

import com.gdyx.dbo.model.Demo;
import com.gdyx.dbo.svc.DemoSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by mac on 2017/5/12.
 */
@Controller
@RequestMapping("/")
public class ViewController {
    @Autowired
    DemoSvc svc;
    @GetMapping
    public String index(ModelMap map){
        List<Demo> list=svc.findDemos();
        map.addAttribute("list",list);
        return "index";
    }
}
