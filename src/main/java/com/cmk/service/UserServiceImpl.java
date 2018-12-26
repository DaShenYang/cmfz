package com.cmk.service;

import com.cmk.dto.TemplatePageDto;
import com.cmk.entity.Banner;
import com.cmk.entity.Province;
import com.cmk.entity.User;
import com.cmk.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Integer> selectCounts(int[] a) {
        List<Integer> list = new ArrayList<>();

        for (int i : a) {
            list.add(userMapper.selectCounts(i));
        }

        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Province> distribution(int sex) {
        return userMapper.distribution(sex);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public TemplatePageDto<User> queryAllUserByPage(int curPage, int pageSize) {
        Example example = new Example(Banner.class);
        example.orderBy("id").desc();


        PageHelper.startPage(curPage, pageSize);
        List<User> list = userMapper.selectByExample(example);


        return new TemplatePageDto<User>(userMapper.selectCount(new User()), list);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<User> queryAllUser() {
        return userMapper.selectAll();
    }
}
