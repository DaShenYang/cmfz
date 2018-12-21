package com.cmk.service;

import com.cmk.dto.TemplatePageDto;
import com.cmk.entity.Album;
import com.cmk.mapper.AlbumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumMapper albumMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public TemplatePageDto<Album> queryAlbumByPage(int curPage, int pageSize) {
        //PageHelper.startPage(curPage, pageSize);
        List<Album> list = albumMapper.queryAllAlbum(curPage, pageSize);
        //System.out.println(list);   结果为Page类型
        return new TemplatePageDto<Album>(albumMapper.selectCount(new Album()), list);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Album queryOneAlbum(int id) {
        return albumMapper.selectByPrimaryKey(id);
    }
}
