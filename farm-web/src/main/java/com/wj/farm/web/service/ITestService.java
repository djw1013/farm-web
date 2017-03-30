package com.wj.farm.web.service;

import java.util.List;

import com.wj.farm.entity.TestEntity;

public interface ITestService {
    List<TestEntity> queryList(String name);
}
