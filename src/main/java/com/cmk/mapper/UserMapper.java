package com.cmk.mapper;

import com.cmk.entity.Province;
import com.cmk.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    int selectCounts(int a);

    List<Province> distribution(int sex);
}
