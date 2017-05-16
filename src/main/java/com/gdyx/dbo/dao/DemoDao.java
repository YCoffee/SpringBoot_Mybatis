package com.gdyx.dbo.dao;

import com.gdyx.dbo.model.Demo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by mac on 2017/5/12.
 */
@Mapper
public interface DemoDao {
    void save(Demo o);
    List<Demo> findDemos();
}
