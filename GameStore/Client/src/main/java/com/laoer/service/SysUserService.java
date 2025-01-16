package com.laoer.service;

import com.laoer.pojo.SysUser;

/**
 * 该类定义了以sys_user表格为核心的业务处理功能
 * @author Laoer
 * @date 2024/12/5 17:41
 * @version 2021.3
 */
public interface SysUserService {
    
    /**
     * @author Laoer
     * @Param sysUser 要注册的用户名和密码，用sysUser对象的形式接收
     * @return 注册成功返回1，失败返回0
     * @date 2024/12/8 16:41
     */
    int regist(SysUser sysUser);

    /**
     * 根据用户名获得完整用户信息的方法
     * @author Laoer
     * @Param username 要查询的用户名
     * @return 如果找到了返回SysUser对象，找不到返回null
     * @date 2024/12/9 16:29
     */
    SysUser findByUsername(String username);
}
