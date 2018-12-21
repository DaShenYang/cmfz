package com.cmk.service;

import com.cmk.dto.TemplatePageDto;
import com.cmk.entity.Album;

public interface AlbumService {
    public TemplatePageDto<Album> queryAlbumByPage(int curPage, int pageSize);

    Album queryOneAlbum(int id);
}
