package com.cmk.service;

import com.cmk.entity.Admin;
import com.cmk.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminMapper;
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Admin login(String name, String password) {
        try {
                Admin admin=adminMapper.selectOne(new Admin(null,name,null));
            if(admin==null) {
                throw new RuntimeException("用户名不存在!");
            }
            if(!admin.getPassword().equals(password)) {
                throw new RuntimeException("密码错误!");
            }
            return admin;
        }catch (Exception e){
            //e.printStackTrace();
            throw new RuntimeException(e.getMessage());

        }
    }
}
