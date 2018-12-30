package com.cmk;


import com.alibaba.fastjson.JSONObject;
import com.cmk.entity.Province;
import com.cmk.service.UserService;
import io.goeasy.GoEasy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzApplicationTests {


    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() {
        String s = UUID.randomUUID().toString().replace("-", "");
        System.out.println(s);
    }


    @Test
    public void testGoEasy() {

        GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-6181be6f6c304014bef36247abb9ef87");
        goEasy.publish("1228", "大神之威");
    }


    @Test
    public void testUpdate() {


        GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-6181be6f6c304014bef36247abb9ef87");
        List<Province> provinceList = userService.distribution(0);
        goEasy.publish("1228", JSONObject.toJSONString(provinceList));

        List<Province> provinceList2 = userService.distribution(1);
        goEasy.publish("1828", JSONObject.toJSONString(provinceList2));
    }


}

