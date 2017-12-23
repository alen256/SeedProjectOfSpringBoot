package com.jiangzhou.seed.mapper;

import com.jiangzhou.seed.core.MyMapper;
import com.jiangzhou.seed.model.Test;
import com.jiangzhou.seed.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends MyMapper<User> {
    @Select("select u1.username u1name, u2.username u2name from user u1 inner join user u2 on u1.id = u2.id")
    List<Test> getTest();
}
