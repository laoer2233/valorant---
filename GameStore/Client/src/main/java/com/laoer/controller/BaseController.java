package com.laoer.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

/**
 * @author Laoer
 * @version 2021.3
 * @date 2024/12/30 8:25
 */
public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestURI = req.getRequestURI();
        String[] splits = requestURI.split("/");
        String methodName = splits[splits.length - 1];

        //使用反射调用方法
        Class aClass = this.getClass();
        try {
            System.out.println("can 1");
            Method declaredMethod = aClass.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            //暴力破解方法的访问修饰符的权限限制
            declaredMethod.setAccessible(true);

            declaredMethod.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}