package com.laoer.controller;

import com.laoer.service.SysUserService;
import com.laoer.service.impl.SysUserServiceImpl;
import com.laoer.util.MD5Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.laoer.pojo.SysUser;

import java.io.IOException;

/**
 * @author Laoer
 * @version 2021.3
 * @date 2024/12/5 17:47
 */

@WebServlet("/user/*")
public class UserController extends BaseController {

    private SysUserService userService =new SysUserServiceImpl();

    /**
     * @author Laoer
     * @Param req
     * @return
     * @date 2024/12/8 16:19
     */

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 接收客户端提交的参数
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");

        //2 调用服务层方法，完成注册功能
        //以后参数多可以放入到一个SysUser对象中，写一个工具类将参数自带封装成pojo类
        SysUser sysUser = new SysUser(null, username, userPwd);
        int rows = userService.regist(sysUser);

        //3 根据注册结果，完成页面跳转
        if(rows>0){
            resp.sendRedirect("/registSuccess.html");
        }else {
            resp.sendRedirect("/registFail.html");
        }
    }


    /**
     * 接收用户登录请求，完成登录业务接口
     * @author Laoer
     * @Param
     * @return
     * @date 2024/12/9 16:18
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 接收用户名和密码
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");

        //2 查询用户信息
        SysUser loginUser = userService.findByUsername(username);
        if (null==loginUser){
            //3 跳转到用户名有误页面
            resp.sendRedirect("/loginUsernameError.html");
        }else if(!MD5Util.encrypt(userPwd).equals(loginUser.getUserPwd())){
            //4 跳转到密码有误页面
            resp.sendRedirect("/loginUserPwdError.html");
        }else {
//            System.out.println(loginUser);
            //登录成功之后，将登录的用户信息放入到session
            HttpSession session=req.getSession();
            session.setAttribute("system",loginUser);
            //5 跳转到首页
            resp.sendRedirect("/index.html");
        }
    }
}
