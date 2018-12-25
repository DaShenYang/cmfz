package com.cmk.controller;

import com.cmk.dto.TemplatePageDto;
import com.cmk.entity.Province;
import com.cmk.entity.User;
import com.cmk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/activeUser")
    public Map<String, Object> activeUser() {
        Map<String, Object> map = new HashMap();
        int[] a = {7, 14, 21, 28, 35};
        List<Integer> list = new ArrayList<>();

        String[] c = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] + "天";

        }
        list = userService.selectCounts(a);
        map.put("intervals", c);
        map.put("counts", list);
        return map;
    }


    @RequestMapping("/distribution")
    public List<Province> distribution(int sex) {


        return userService.distribution(sex);
    }


    @RequestMapping("/queryAllUserByPage")
    public TemplatePageDto<User> queryAllUserByPage(int page, int rows) {
        return userService.queryAllUserByPage(page, rows);
    }


    @RequestMapping("/update")
    public void update(User user) {
        userService.update(user);
    }
}
