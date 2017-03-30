package com.wj.farm.web.controller.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * 统一异常处理，所有controller继承此类
 *
 * @author 16060834
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class BaseController {
    private static Logger logger = LoggerFactory.getLogger(BaseController.class);
    
    @ExceptionHandler
    public String handleException(HttpServletRequest request, HttpServletResponse response, Exception e) {

        printException(e);// log4j打印错误级别堆栈日志信息，时间
        // json格式的ajax请求
        if (request.getHeader("accept").indexOf("application/json") > -1
                || (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").indexOf(
                        "XMLHttpRequest") > -1)) {
            response.setStatus(500);
            response.setContentType("application/json;charset=utf-8");
            try {
                PrintWriter writer = response.getWriter();
                if (e instanceof RuntimeException) {// 运行时异常
                    writer.write("系统内部异常！");
                } else {// 非运行时异常
                    writer.write(e.getMessage());// 此处待细化异常处理给提示 ？？？
                }
                writer.flush();
            } catch (IOException e1) {
                logger.error("打印异常出错",e1);
                e1.printStackTrace();
            }
            return null;
        } else {// URL普通请求
            if (e instanceof RuntimeException) {// 运行时异常
                request.setAttribute("exceptionMessage", "系统内部异常！");
            } else {
                request.setAttribute("exceptionMessage", e.getMessage());// 此处待细化异常处理给显示 ？？？
            }
            try {// 跳转统一异常处理界面
                request.getRequestDispatcher("../error.jsp").forward(request, response);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            return null;
        }
    }

    public void printException(Exception e) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            // 将出错的栈信息输出到printWriter中
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
        logger.error(new Date() + ":" + sw.toString());
    }

}
