package com.wj.farm.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wj.farm.entity.TestEntity;
import com.wj.farm.web.controller.base.BaseController;
import com.wj.farm.web.service.ITestService;
/**
 * 
 * 测试
 * 〈功能详细描述〉
 *
 * @author 16060834
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController{
    @Autowired
    private ITestService iTestService;
    
    private static Logger logger = LoggerFactory.getLogger(TestController.class);
    
    @RequestMapping("/test")
    @ResponseBody
    public TestEntity test(@RequestBody TestEntity entity){
        List<TestEntity> list = iTestService.queryList(entity.getName());
        logger.info("---------------------测试成功-----------------"+list);
        return list.get(0);
    }

}
