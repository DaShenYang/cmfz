package com.cmk.service;

import com.cmk.entity.User;

public interface InterFacService {
    Object queryMain(String uid, String type, String sub_type);//首页

    Object queryArticle(String id, String uidc);

    Object queryAlbum(String id, String uid);

    Object login(String phone, String password, String code);

    Object regist(String phone, String password);

    Object updateUser(User user);

    Object queryCode(String phone) throws Exception;//获取短信验证码借口

    Object isCode(String phone, String code);//短信验证码校验借口

    Object queryUserFriend(String uid);
}
