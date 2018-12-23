package com.cmk.controller;

import com.cmk.dto.TemplatePageDto;
import com.cmk.entity.Album;
import com.cmk.service.AlbumService;
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
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/queryAllAlbumByPage")
    public TemplatePageDto<Album> queryAllAlbumByPage(int page, int rows) {
        return albumService.queryAlbumByPage(page, rows);
    }

    @RequestMapping("/queryOneAlbum")
    public Album queryOneAlbum(int id) {
        return albumService.queryOneAlbum(id);
    }


    @RequestMapping("/addAlbum")
    public void addAlbum(MultipartFile file2, Album album, HttpSession session) throws IOException {
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/cover");
        String oldName = file2.getOriginalFilename();
        // 目标文件
        File descFile = new File(realPath + "/" + oldName);
        // 上传
        file2.transferTo(descFile);

        album.setCount(0);
        album.setCoverImg("cover/" + oldName);
        album.setPubDate(new Date());


        albumService.addAlbum(album);

    }
}
