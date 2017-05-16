package com.gdyx.dbo.svc.impl;

import com.gdyx.dbo.dao.DemoDao;
import com.gdyx.dbo.model.Demo;
import com.gdyx.dbo.svc.DemoSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mac on 2017/5/12.
 */
@Service
public class DemoSvcImpl implements DemoSvc {
    @Autowired
    DemoDao dao;

    @Override
    public void save(Demo o) {
dao.save(o);
    }

    @Override
    public List<Demo> findDemos() {
        return dao.findDemos();
    }
}
