package com.laoer.service.impl;

import com.laoer.dao.SysUserDao;
import com.laoer.dao.SysUserDao;
import com.laoer.dao.impl.SystemUserDaoImpl;
import com.laoer.pojo.SysUser;
import com.laoer.util.MD5Util;
import com.laoer.service.SysUserService;

/**
 * @author Laoer
 * @version 2021.3
 * @date 2024/12/5 17:43
 */
public class SysUserServiceImpl implements SysUserService {

    private SysUserDao userDao=new SystemUserDaoImpl();

    @Override
    public int regist(SysUser sysUser) {

        //将用户的明文密码转换成密文密ma
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));

        //将sysUser信息存入数据库
         return userDao.addSysUser(sysUser);

    }

    @Override
    public SysUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
