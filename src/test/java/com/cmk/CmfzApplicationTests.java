package com.cmk;


import io.goeasy.GoEasy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzApplicationTests {

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

}

