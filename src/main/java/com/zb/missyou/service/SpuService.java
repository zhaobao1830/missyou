package com.zb.missyou.service;

import com.zb.missyou.model.Spu;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SpuService {
    Spu getSpu(Long id);
    Page<Spu> getLatestPagingSpu(Integer pageNum, Integer size);
}
