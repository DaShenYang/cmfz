package com.cmk.service;

import com.cmk.dto.BannerPageDto;

public interface BannerService {
    public BannerPageDto queryByPage(int curPage, int pageSize);
}
