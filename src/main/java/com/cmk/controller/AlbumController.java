package com.cmk.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.cmk.dto.TemplatePageDto;
import com.cmk.entity.Album;
import com.cmk.service.AlbumService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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
    public void addAlbum(MultipartFile file2, Album album, HttpSession session) {
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/cover");
        String oldName = file2.getOriginalFilename();
        // 目标文件
        File descFile = new File(realPath + "/" + oldName);
        // 上传
        try {
            file2.transferTo(descFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        album.setCount(0);
        album.setCoverImg("cover/" + oldName);
        album.setPubDate(new Date());


        albumService.addAlbum(album);

    }


    @RequestMapping("/poiExport")

    public String poiExport(HttpSession session) {
        int count = albumService.selectCount();
        TemplatePageDto<Album> albumTemplatePageDto = albumService.queryAlbumByPage(1, count);
        List<Album> albums = albumTemplatePageDto.getRows();

        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/");

        for (Album album : albums) {
            album.setCoverImg(realPath + album.getCoverImg());
        }


        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("专辑与音频信息", "圣诞夜制作"),
                Album.class, albums);

        try {
            workbook.write(new FileOutputStream(new File("E:/easypoi.xls")));

            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
