package com.zb.missyou.util;

import com.zb.missyou.bo.PageCounter;

public class CommonUtil {

    public static PageCounter converToPageParameter(Integer start, Integer count){
        int pageNum = start/count;
        PageCounter pageCounter = PageCounter.builder()
                .page(pageNum)
                .count(count)
                .build();
        return pageCounter;
    }
}
