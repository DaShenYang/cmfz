package com.cmk.controller;

import com.cmk.dto.TemplatePageDto;
import com.cmk.entity.Album;
import com.cmk.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
