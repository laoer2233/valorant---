package com.laoer.dao.impl;

import com.laoer.dao.BaseDao;
import com.laoer.dao.SysUserDao;
import com.laoer.pojo.SysUser;

import java.util.List;

public class SystemUserDaoImpl extends BaseDao implements SysUserDao {


    @Override
    public int addSysUser(SysUser sysUser) {
        String sql ="insert into users values(DEFAULT,?,?)";
        return baseUpdate(sql,sysUser.getUsername(),sysUser.getUserPwd());
    }


    @Override
    public SysUser findByUsername(String username) {
        String sql="select UserID uid,Username username,Password userPwd from users where username=?";
        List<SysUser> sysUserList = baseQuery(SysUser.class, sql, username);
        System.out.println(sysUserList);
        return sysUserList!=null&&sysUserList.size()>0?sysUserList.get(0):null;
    }
}
