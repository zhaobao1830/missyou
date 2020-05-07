package com.zb.missyou.vo;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PagingDozer<T, K> extends Paging{
    @SuppressWarnings("unchecked")
    public PagingDozer(Page<T> pageT, Class<K> classk) {
        this.initPageParameters(pageT);

        // 使用DozerBeanMapper拷贝属性
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<T> tList = pageT.getContent();
        List<K> voList = new ArrayList<>();
        // 将查询出的数据循环赋值到vo中
        tList.forEach(t -> {
            // t是源文件，classk是目标文件的class
            K vo = mapper.map(t, classk);
            voList.add(vo);
        });
        this.setItems(voList);
    }
}
