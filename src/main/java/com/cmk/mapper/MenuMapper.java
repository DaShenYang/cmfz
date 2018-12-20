package com.cmk.mapper;

import com.cmk.entity.Menu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MenuMapper extends Mapper<Menu> {
    public List<Menu> queryAllMenu();
}
