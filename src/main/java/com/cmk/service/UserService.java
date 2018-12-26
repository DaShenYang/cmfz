package com.cmk.service;

import com.cmk.dto.TemplatePageDto;
import com.cmk.entity.Province;
import com.cmk.entity.User;

import java.util.List;

public interface UserService {
    List<Integer> selectCounts(int[] a);

    List<Province> distribution(int sex);

    TemplatePageDto<User> queryAllUserByPage(int curPage, int pageSize);

    void update(User user);


    List<User> queryAllUser();

}
