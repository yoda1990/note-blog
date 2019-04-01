package com.hmily.noteblog.service.api;

import java.util.List;
import java.util.Map;

/**
 * Created by zyzhmily on 2018/2/3.
 */
public interface UserService {

    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name, Integer age);

    /**
     * 根据name删除一个用户高
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户总量
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

    /**
     * 查询所有用户
     */
    List<Map<String, Object>> findUserList();

}
