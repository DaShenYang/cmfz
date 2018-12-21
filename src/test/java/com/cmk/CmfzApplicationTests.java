package com.cmk;

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

}

