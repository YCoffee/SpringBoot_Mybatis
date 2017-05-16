package com.gdyx.dbo.svc;

import com.gdyx.dbo.model.Demo;

import java.util.List;

/**
 * Created by mac on 2017/5/12.
 */
public interface DemoSvc {
    void save(Demo o);
    List<Demo> findDemos();
}
