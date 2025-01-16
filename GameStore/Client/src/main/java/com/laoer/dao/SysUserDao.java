package com.laoer.dao;


import com.laoer.pojo.SysUser;

public interface SysUserDao {

    /**
     * 向数据库中增加一条用户记录的方法
     * @author Laoer
     * @Param sysUser 要增加的记录的username和userPwd字段以sysuser实体类的形式接收
     * @return 增加成功返回1，失败返回0
     * @date 2024/12/8 16:53
     */
    int addSysUser(SysUser sysUser);

    /**
     * 根据用户名获得完整用户信息的方法
     * @author Laoer
     * @Param username 要查询的用户名
     * @return 如果找到了返回SysUser对象，找不到返回null
     * @date 2024/12/9 16:29
     */
    SysUser findByUsername(String username);
}
