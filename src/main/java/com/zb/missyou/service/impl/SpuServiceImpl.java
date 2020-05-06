package com.zb.missyou.service.impl;

import com.zb.missyou.model.Spu;
import com.zb.missyou.repository.SpuRepository;
import com.zb.missyou.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuRepository spuRepository;

    @Override
    public Spu getSpu(Long id) {
        return spuRepository.findOneById(id);
    }

    @Override
    public List<Spu> getLatestPagingSpu() {
        return spuRepository.findAll();
    }
}
