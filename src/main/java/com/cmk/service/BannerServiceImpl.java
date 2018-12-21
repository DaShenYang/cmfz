package com.cmk.service;

import com.cmk.dto.TemplatePageDto;
import com.cmk.entity.Banner;
import com.cmk.mapper.BannerMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public TemplatePageDto<Banner> queryByPage(int curPage, int pageSize) {

        //List<Banner> list = bannerMapper.selectAll();

        Example example = new Example(Banner.class);
        example.orderBy("id").desc();

        PageHelper.startPage(curPage, pageSize);
        List<Banner> list = bannerMapper.selectByExample(example);

        return new TemplatePageDto<Banner>(bannerMapper.selectCount(new Banner()), list);
    }

    @Override
    public void delete(Integer id) {
        bannerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Banner banner) {
        bannerMapper.updateByPrimaryKey(banner);
    }

    @Override
    public void addBanner(Banner banner) {
        bannerMapper.insert(banner);
    }
}
