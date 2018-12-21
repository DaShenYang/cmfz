package com.cmk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplatePageDto<T> implements Serializable {
    private Integer total;
    private List<T> rows;
}
