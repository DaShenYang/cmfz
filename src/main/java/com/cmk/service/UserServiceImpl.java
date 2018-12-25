package com.cmk.service;

import com.cmk.entity.Province;
import com.cmk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
}
