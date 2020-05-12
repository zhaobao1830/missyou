package com.zb.missyou.bo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PageCounter {
//    当前页码
    private Integer pageNum;
//    每页的条数
    private Integer pageSize;
}
