package com.cmk.service;

import com.cmk.entity.Province;

import java.util.List;

public interface UserService {
    List<Integer> selectCounts(int[] a);

    List<Province> distribution(int sex);
}
