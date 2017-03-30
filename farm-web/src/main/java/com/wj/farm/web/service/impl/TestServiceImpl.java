package com.wj.farm.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wj.farm.dao.ITestDao;
import com.wj.farm.entity.TestEntity;
import com.wj.farm.web.service.ITestService;

@Service
public class TestServiceImpl implements ITestService{
    
    @Autowired
    private ITestDao iTestDao;
    public List<TestEntity> queryList(String name) {
        return iTestDao.queryList(name);
    }

}
