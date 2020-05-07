﻿package com.zb.missyou.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

//封装分页实体类
@Getter
@Setter
@NoArgsConstructor
public class Paging<T> {
    // 总条数
    private Long total;
    // 当前返回的条数
    private Integer count;
    // 当前页吗
    private Integer page;
    // 总页数
    private Integer totalPage;
    // 结果
    private List<T> items;

    public Paging(Page<T> pageT) {
        this.initPageParameters(pageT);
        this.items = pageT.getContent();
    }

    void initPageParameters(Page<T> pageT) {
        this.total = pageT.getTotalElements();
        this.count = pageT.getSize();
        this.page = pageT.getNumber();
        this.totalPage = pageT.getTotalPages();
    }
}
