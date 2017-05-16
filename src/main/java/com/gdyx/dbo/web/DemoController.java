package com.gdyx.dbo.web;

import com.gdyx.dbo.model.Demo;
import com.gdyx.dbo.svc.DemoSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * Created by mac on 2017/5/12.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    DemoSvc svc;

    @RequestMapping(value = "/save")
    @ResponseBody
    public String save(){
        Demo demo=new Demo();
        demo.setId(UUID.randomUUID().toString().toUpperCase());
        demo.setName("USER"+System.currentTimeMillis());
        demo.setPasv("123456");
        demo.setDescr("descr");
        svc.save(demo);
        return "OK";
    }
}
