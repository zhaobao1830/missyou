package com.zb.missyou.util;

import com.zb.missyou.bo.PageCounter;

public class CommonUtil {
//    将 start、count转换为pageNum、pageSie
    public static PageCounter converToPageParameter(Integer start, Integer count){
        int pageNum = start/count;
        PageCounter pageCounter = PageCounter.builder()
                .pageNum(pageNum)
                .pageSize(count)
                .build();
        return pageCounter;
    }
}
