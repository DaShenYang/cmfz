package com.cmk.controller;

import com.cmk.conf.VideoUtil;
import com.cmk.entity.Album;
import com.cmk.entity.Chapter;
import com.cmk.service.AlbumService;
import com.cmk.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;


    @Autowired
    private AlbumService albumService;

    @ResponseBody
    @RequestMapping("/addChapter")
    public void addChapter(MultipartFile file3, Chapter chapter, HttpSession session) throws IOException {

        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/mp3");
        String oldName = file3.getOriginalFilename();
        String path = realPath + "/" + oldName;
        // 目标文件
        File descFile = new File(path);
        // 上传
        file3.transferTo(descFile);


        String s = UUID.randomUUID().toString().replace("-", "");
        chapter.setId(s);

        String size = VideoUtil.getFileSize(path);
        chapter.setSize(size);
        String duration = VideoUtil.getDuration(path);
        chapter.setDuration(duration);
        chapter.setUrl("mp3/" + oldName);

        chapter.setUploadDate(new Date());

        chapterService.addChapter(chapter);

        Album album = albumService.queryOneAlbum(chapter.getAlbumId());
        album.setCount(album.getCount() + 1);
        albumService.updateAlbumById(album);


    }


    //@RequestMapping(value = "/downloadChapter/{url}",produces = "application/json;charset=UTF-8")
    //public void downloadChapter(@PathVariable("url")String url, HttpSession session, HttpServletResponse response)throws  Exception{
    @RequestMapping("/downloadChapter")
    public void downloadChapter(String url, HttpSession session, HttpServletResponse response) throws Exception {

        String realPath = session.getServletContext().getRealPath("/");
        File file = new File(realPath + url);
        //URLEncoder.encode(url,"UTF-8");
        String s[] = url.split("/");
        String fileName = s[1];

        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);

        byte[] buffer = new byte[1024];
        FileInputStream fis = null; //文件输入流
        BufferedInputStream bis = null;

        OutputStream os = null; //输出流

        os = response.getOutputStream();
        fis = new FileInputStream(file);
        bis = new BufferedInputStream(fis);
        int i = bis.read(buffer);
        while (i != -1) {
            os.write(buffer);
            i = bis.read(buffer);
        }


        bis.close();
        fis.close();


    }


}
