package com.laoer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.laoer.pojo.Skin;
import com.laoer.pojo.SysUser;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface SkinService {

    /**
     * 从数据库中抽取枪皮
     * @author Laoer
     * @return 以键值对的方式返回抽取是否成功及枪皮信息
     * @date 2025/1/2 22:24
     */
    Map<String,Object> extractSkin();

    /**
     * 处理来自客户端的多个皮肤数据
     * 将json格式的skin转换为skin对象类
     * @author Laoer
     * @date 2025/1/2 22:31
     */
    List<Skin> processSkinData(String requestBody) throws IOException;

    /**
     * 将购买的skin保存到数据库中
     * @author Laoer
     * @date 2025/1/2 22:31
     */
    void saveSkins(List<Skin> skins, SysUser sysUser);
}
