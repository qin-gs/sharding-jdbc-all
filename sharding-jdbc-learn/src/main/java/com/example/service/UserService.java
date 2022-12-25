package com.example.service;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;


    public List<User> getUsers() {
        return mapper.getUsers();
    }

    public User addUser() {
        User user = User.builder()
                .username(RandomUtil.randomString(6))
                .password(RandomUtil.randomString(8))
                .age(RandomUtil.randomInt(80))
                .build();
        HintManager instance = HintManager.getInstance();
        instance.addTableShardingValue("user", user.getAge());
        instance.setMasterRouteOnly();
        Integer i = mapper.addUser(user);
        instance.close();
        return user;
    }
}
