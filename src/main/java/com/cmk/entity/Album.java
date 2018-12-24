package com.cmk.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "album")
//@ExcelTarget(value="album")
public class Album implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    @ExcelIgnore
    private Integer id;
    @Excel(name = "专辑名称", needMerge = true)
    private String title;
    @Excel(name = "专辑数量", needMerge = true)
    private Integer count;
    @Excel(name = "封面", type = 2, width = 50, height = 60)
    private String coverImg;
    @Excel(name = "专辑评分", needMerge = true)
    private Integer score;
    @Excel(name = "专辑作者", needMerge = true)
    private String author;
    @Excel(name = "专辑播音", needMerge = true)
    private String broadcast;
    @Excel(name = "专辑简介", needMerge = true)
    private String brief;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "发布日期", format = "YYYY年MM月dd日", width = 20, needMerge = true)
    private Date pubDate;
    @Transient
    @ExcelCollection(name = "音频信息")
    private List<Chapter> children;
}
