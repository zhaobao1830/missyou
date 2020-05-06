package com.zb.missyou.service;

import com.zb.missyou.model.Spu;

import java.util.List;

public interface SpuService {
    Spu getSpu(Long id);
    List<Spu> getLatestPagingSpu();
}
