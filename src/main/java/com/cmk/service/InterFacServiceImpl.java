package com.cmk.service;

import com.cmk.conf.MsgCode;
import com.cmk.entity.User;
import com.cmk.exception.ErrorException;
import com.cmk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Service
@Transactional
public class InterFacServiceImpl implements InterFacService {

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Object queryMain(String uid, String type, String sub_type) {
        HashMap<String, Object> map = new HashMap<>();
        if (uid == null || type == null) {
            return new ErrorException("uid或type不能为空");
        } else {
            if (type.equals("all")) {
                map.put("banner", "轮播图集合");
                map.put("album", "专辑集合");
                map.put("article", "文章集合");
                return map;
            } else if (type.equals("wen")) {
                map.put("album", "专辑集合");
                return map;
            } else {
                if (sub_type != null) {
                    if (sub_type.equals("ssyj")) {
                        map.put("article", "上师的文章集合");
                        return map;
                    } else {
                        map.put("article", "其他上师的文章集合");
                        return map;
                    }

                } else {
                    return new ErrorException("sub_type不能为空");
                }
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Object queryArticle(String id, String uidc) {
        HashMap<String, Object> map = new HashMap<>();
        if (id == null || uidc == null) {
            return new ErrorException("id或uidc不能为空");
        } else {
            map.put("article", "文章对象");
            return map;
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Object queryAlbum(String id, String uid) {
        HashMap<String, Object> map = new HashMap<>();
        if (id == null || uid == null) {
            return new ErrorException("id或uid不能为空");
        } else {
            map.put("album", "专辑对象");
            return map;
        }
    }

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HttpSession session;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Object login(String phone, String password, String code) {
        HashMap<String, Object> map = new HashMap<>();
        if (phone == null) {
            return new ErrorException("phone不能为空");

        } else {
            User u = new User();
            u.setPhone(phone);
            User user = userMapper.selectOne(u);
            if (user == null) {
                map.put("error", "phone不存在");
                return map;
            } else {
                if (password != null) {
                    if (!user.getPassword().equals(password)) {
                        map.put("error", "密码错误");
                    } else {
                        map.put("success", "用户信息");

                    }
                    return map;

                } else if (code != null) {
                    String code1 = (String) session.getAttribute("code");
                    if (!code.equals(code1)) {
                        map.put("error", "短信验证码错误");
                    } else {
                        map.put("success", "用户信息");

                    }
                    return map;
                } else {
                    return new ErrorException("password或code其中一个不能为空");
                }

            }


        }
    }

    @Override
    public Object regist(String phone, String password) {
        HashMap<String, Object> map = new HashMap<>();
        if (phone == null || password == null) {
            return new ErrorException("phone或password不能为空");
        } else {
            User u = new User();
            u.setPhone(phone);
            User user = userMapper.selectOne(u);
            if (user == null) {
                map.put("success", "用户信息");
            } else {
                map.put("error", "该手机号已经被注册");

            }
            return map;
        }
    }

    @Override
    public Object updateUser(User user) {
        HashMap<String, Object> map = new HashMap<>();
        if (user.getId() == null) {
            return new ErrorException("用户id不能为空");
        } else {
            if (user.getPhone() != null) {
                User u = new User();
                u.setPhone(user.getPhone());
                User user2 = userMapper.selectOne(u);
                if (user2 == null) {
                    map.put("success", "用户信息");
                } else {
                    map.put("error", "该手机号已经被使用");

                }
                return map;
            } else {
                map.put("success", "用户信息");
                return map;
            }
        }
    }

    @Override
    public Object queryCode(String phone) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        if (phone == null) {
            return new ErrorException("phone不能为空");
        } else {
            String code = MsgCode.send(phone);
            session.setAttribute("code", code);
            map.put("code", code);
            return map;
        }
    }

    @Override
    public Object isCode(String phone, String code) {
        HashMap<String, Object> map = new HashMap<>();
        if (phone == null || code == null) {
            return new ErrorException("phone或code不能为空");
        } else {
            if (code.equals((String) session.getAttribute("code"))) {
                map.put("success", true);
            } else {
                map.put("fail", false);
            }
            return map;
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Object queryUserFriend(String uid) {
        HashMap<String, Object> map = new HashMap<>();
        if (uid == null) {
            return new ErrorException("uid不能为空");
        } else {
            map.put("金刚道友", "随机抽取的五个用户集合");
            return map;
        }
    }


}
