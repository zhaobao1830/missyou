package com.zb.missyou.service;

import com.zb.missyou.model.Spu;
import org.springframework.data.domain.Page;

public interface SpuService {
    Spu getSpu(Long id);
    Page<Spu> getLatestPagingSpu(Integer pageNum, Integer size);
    Page<Spu> getByCategoryId(Long cid, Boolean isRoot, Integer pageNum, Integer size);
}
