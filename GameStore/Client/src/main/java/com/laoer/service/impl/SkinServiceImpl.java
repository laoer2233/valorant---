package com.laoer.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laoer.dao.SkinDao;
import com.laoer.dao.impl.SkinDaoImpl;
import com.laoer.pojo.Skin;
import com.laoer.pojo.SysUser;
import com.laoer.service.SkinService;
import com.laoer.pojo.CartWrapper;

import java.io.IOException;
import java.util.*;

/**
 * @author Laoer
 * @version 2021.3
 * @date 2025/1/1 17:14
 */
public class SkinServiceImpl implements SkinService {

    private SkinDao skinDao=new SkinDaoImpl();
    @Override
    public Map<String, Object> extractSkin() {
        Map<String, Object> successResponse = new HashMap<>();
        System.out.println("can 3");
        Random random = new Random();
        List<Skin> lss=skinDao.findall();
        System.out.println(lss.size());
        Skin ls=lss.get(random.nextInt(lss.size()));

        successResponse.put("success", true);
        successResponse.put("imageUrl", ls.getImagePath());
        successResponse.put("skinName", ls.getName());
        successResponse.put("price", ls.getPrice());
        successResponse.put("ProductId",ls.getProductID());
//      successResponse.put("color", ls.getColor());
        System.out.println(ls.getProductID());
        return successResponse;
    }

    // 处理来自客户端的多个皮肤数据
    public List<Skin> processSkinData(String requestBody) throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            CartWrapper wrapper = objectMapper.readValue(requestBody, CartWrapper.class);
            return wrapper.getCart();
        } catch (JsonProcessingException e) {
            throw new IOException("Invalid JSON format", e);
        }
    }




    // 假设我们将皮肤信息存储到数据库中（这里是示例）
    @Override
    public void saveSkins(List<Skin> skins, SysUser sysUser) {
        // 假设我们有一个数据访问层（DAO）来处理数据库操作
        System.out.println("ccan 5");
        for (Skin skin : skins) {
            // 将每个 skin 对象保存到数据库
            skinDao.saveSkin(skin,sysUser);
        }
    }
}

