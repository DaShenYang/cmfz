package com.cmk.mapper;

import com.cmk.entity.Album;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AlbumMapper extends Mapper<Album> {

    public List<Album> queryAllAlbum(@Param("curPage") int curPage, @Param("pageSize") int pageSize);

}
