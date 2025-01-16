package com.laoer.controller;

import com.laoer.pojo.Skin;
import com.laoer.pojo.SysUser;
import com.laoer.service.SkinService;
import com.laoer.service.impl.SkinServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Laoer
 * @version 2021.3
 * @date 2025/1/1 16:41
 */

@WebServlet("/SkinController/*")
public class SkinController extends BaseController{

    private SkinService skinService=new SkinServiceImpl();

    protected void extractSkin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        System.out.println("can 2");

        Map<String, Object> successResponse=skinService.extractSkin();
        resp.getWriter().write(new Gson().toJson(successResponse));

    }

    //SkinService 类：将具体的 JSON 解析逻辑从 Servlet 中提取到 Service 层，以便更好地解耦和重用代码。
    //SkinServlet 类：在 Servlet 中调用 SkinService 的方法来处理请求
    protected void addToCart(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        // 获取请求体中的 JSON 数据
        StringBuilder requestBody = new StringBuilder();
        String line;
        BufferedReader reader = req.getReader();
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        System.out.println("ccann 2");
        // 调用 SkinService 处理 JSON 数据
        try {
            List<Skin> skins = skinService.processSkinData(requestBody.toString());
            System.out.println(skins);
            SysUser sysUser=(SysUser) req.getSession().getAttribute("system");
            // 保存皮肤数据到数据库
            skinService.saveSkins(skins,sysUser);

            // 响应返回
            resp.setContentType("application/json");
            resp.getWriter().write("{\"success\":true}");

        } catch (IOException e) {
            // 处理异常
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"success\":false, \"message\":\"购买失败\"}");
            e.printStackTrace();
        }
    }
}
