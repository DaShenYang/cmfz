package com.cmk.service;

import com.cmk.dto.BannerPageDto;
import com.cmk.entity.Banner;
import com.cmk.mapper.BannerMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public BannerPageDto queryByPage(int curPage, int pageSize) {
        PageHelper.startPage(curPage, pageSize);
        List<Banner> list = bannerMapper.selectAll();
        return new BannerPageDto(bannerMapper.selectCount(new Banner()), list);
    }
}
