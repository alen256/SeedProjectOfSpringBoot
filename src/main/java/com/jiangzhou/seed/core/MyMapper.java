package com.jiangzhou.seed.core;

import tk.mybatis.mapper.common.*;
import tk.mybatis.mapper.common.special.InsertListMapper;


/**
 * 定制版MyBatis Mapper插件接口，如需其他接口参考官方文档自行添加。
 */

public interface MyMapper<T>
        extends
        Mapper<T>,
        BaseMapper<T>,
        MySqlMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        InsertListMapper<T> {
}
