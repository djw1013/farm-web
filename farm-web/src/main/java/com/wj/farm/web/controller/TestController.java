package com.wj.farm.web.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class TestController {
    @Autowired
    private ITestService iTestService;
    
    private static Logger logger = LoggerFactory.getLogger(TestController.class);
    
    @RequestMapping("/test")
    public void test(){
        List<Map<String, Object>> list = iTestService.queryList();
        logger.info("---------------------测试成功-----------------"+list);
    }

}
