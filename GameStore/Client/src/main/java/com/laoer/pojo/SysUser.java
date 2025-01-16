package com.laoer.pojo;

/**
 * @author Laoer
 * @version 2021.3
 * @date 2024/12/30 8:36
 */


import java.io.Serializable;
import java.util.Objects;


/**
 *
 * 1 实体类的类名和表格名应该对应
 * 2 实体类的属性名和表格的列名字段名应该对应
 * 3 每个属性都应该是私有的
 * 4 每个属性都应该具备getter setter
 * 5 必须提供无参构造器
 * 6 应该实现序列化接口（缓存 分布式项目数据传递 可能会将对象序列化）
 * 7 应该重写类的hashcode和equals方法
 * 8 toString是否重写都可以
 * */

//@AllArgsConstructor
public class SysUser implements Serializable {
    private Integer uid;
    private String username;
    private String userPwd;

    public SysUser() {
    }

    public SysUser(Integer uid, String username, String userPwd) {
        this.uid = uid;
        this.username = username;
        this.userPwd = userPwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUser sysUser = (SysUser) o;
        return Objects.equals(uid, sysUser.uid) && Objects.equals(username, sysUser.username) && Objects.equals(userPwd, sysUser.userPwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, username, userPwd);
    }

    @Override
    public String  toString() {
        return "SysUser{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

}
