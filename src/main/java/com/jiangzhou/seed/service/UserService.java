package com.jiangzhou.seed.service;

import com.jiangzhou.seed.core.Result;
import com.jiangzhou.seed.core.ResultGenerator;
import com.jiangzhou.seed.core.ServiceException;
import com.jiangzhou.seed.mapper.UserMapper;
import com.jiangzhou.seed.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Result test() {
        String a = "";
        if (a.equals("")) {
            throw new ServiceException("自定义错误");
        }
        return ResultGenerator.genSuccessResult(userMapper.selectByPrimaryKey(1));
    }

    public Result test2() {
        return ResultGenerator.genSuccessResult(userMapper.selectAll());
    }

    @Transactional
    public Result insert() {
        User user1 = new User();
        user1.setUsername("aaa");
        return ResultGenerator.genSuccessResult(userMapper.insert(user1));
    }

    public Result test3() {
        return ResultGenerator.genSuccessResult(userMapper.getTest());
    }

}
