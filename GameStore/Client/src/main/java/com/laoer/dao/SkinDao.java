package com.laoer.dao;

import com.laoer.pojo.Skin;
import com.laoer.pojo.SysUser;

import java.util.List;

public interface SkinDao {

    /**
     * 查询数据库中所有数据
     * @author Laoer
     * @date 2025/1/2 22:38
     */
    List<Skin> findall();

    void saveSkin(Skin skin, SysUser sysUser);
}
