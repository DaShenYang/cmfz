package com.cmk.service;

import com.cmk.exception.ErrorException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
}
