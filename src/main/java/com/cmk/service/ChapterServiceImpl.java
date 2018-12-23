package com.cmk.service;

import com.cmk.entity.Chapter;
import com.cmk.mapper.ChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;

    @Override
    public void addChapter(Chapter chapter) {
        chapterMapper.insert(chapter);
    }
}
