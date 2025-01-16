package com.laoer.dao.impl;

import com.laoer.dao.BaseDao;
import com.laoer.dao.SkinDao;
import com.laoer.pojo.Skin;
import com.laoer.pojo.SysUser;
import com.laoer.pojo.sale;

import java.util.List;

/**
 * @author Laoer
 * @version 2021.3
 * @date 2025/1/1 17:35
 */
public class SkinDaoImpl extends BaseDao implements SkinDao {
    @Override
    public List<Skin> findall() {
        String sql="select * from products";
        System.out.println("can 6");
        return baseQuery(Skin.class, sql);
    }

    @Override
    public void saveSkin(Skin skin,SysUser sysUser) {
        System.out.println("ccan 4");
        // 查询最大数量
        String querySql = "SELECT COALESCE(MAX(Quantity), 0) + 1 AS Quantity " +
                "FROM shoppingcart WHERE UserID = ? AND ProductID = ?";
        int nextQuantity = baseQuery(sale.class,querySql,sysUser.getUid(), skin.getProductID()).size();

        // 插入新记录
        String insertSql = "INSERT INTO shoppingcart (UserID, ProductID, Quantity) VALUES (?, ?, ?)";
        baseUpdate(insertSql, sysUser.getUid(), skin.getProductID(), nextQuantity);

    }
}