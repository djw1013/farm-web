package com.wj.farm.web.controller;

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
    
    @RequestMapping("/test")
    public void test(){
        System.out.println(iTestService.queryList());
    }

}
