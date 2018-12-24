package com.cmk.controller;

import com.cmk.dto.TemplatePageDto;
import com.cmk.entity.Banner;
import com.cmk.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/queryAllBannerByPage")
    public TemplatePageDto<Banner> queryAllBannerByPage(int page, int rows) {
        return bannerService.queryByPage(page, rows);
    }


    @RequestMapping("/delete")
    public void delete(Integer id) {

        bannerService.delete(id);
    }


    @RequestMapping("/update")
    public void update(Banner banner) {
        bannerService.update(banner);
    }

    @RequestMapping("/addBanner")
    public void addBanner(MultipartFile file1, Banner banner, HttpSession session) {


        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/banner");
        String oldName = file1.getOriginalFilename();

        // 目标文件
        File descFile = new File(realPath + "/" + oldName);
        // 上传
        try {
            file1.transferTo(descFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        banner.setImgPath("banner/" + oldName);
        banner.setPubDate(new Date());

        bannerService.addBanner(banner);
    }
}
