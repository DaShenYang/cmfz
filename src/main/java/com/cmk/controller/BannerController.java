package com.cmk.controller;

import com.cmk.dto.BannerPageDto;
import com.cmk.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/queryAllBannerByPage")
    public BannerPageDto queryAllBannerByPage(int page, int rows) {
        return bannerService.queryByPage(page, rows);
    }
}
