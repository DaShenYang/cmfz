package com.cmk.service;

import com.cmk.dto.TemplatePageDto;
import com.cmk.entity.Banner;

public interface BannerService {
    public TemplatePageDto<Banner> queryByPage(int curPage, int pageSize);

    public void delete(Integer id);

    public void update(Banner banner);

    public void addBanner(Banner banner);
}
