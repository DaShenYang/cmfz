package com.cmk.service;

import com.cmk.entity.Menu;
import com.cmk.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuMapper menuMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Menu> queryAllMenu() {
        return menuMapper.queryAllMenu();
    }
}
