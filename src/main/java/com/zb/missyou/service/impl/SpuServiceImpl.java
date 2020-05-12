package com.zb.missyou.service.impl;

import com.zb.missyou.model.Spu;
import com.zb.missyou.repository.SpuRepository;
import com.zb.missyou.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuRepository spuRepository;

    @Override
    public Spu getSpu(Long id) {
        return spuRepository.findOneById(id);
    }

    @Override
    public Page<Spu> getLatestPagingSpu(Integer pageNum, Integer pageSize) {
        Pageable page = PageRequest.of(pageNum, pageSize, Sort.by("createTime").descending());
        return spuRepository.findAll(page);
    }

    @Override
    public Page<Spu> getByCategoryId(Long cid, Boolean isRoot, Integer pageNum, Integer pageSize) {
        Pageable page = PageRequest.of(pageNum, pageSize);
        if (isRoot) {
            return spuRepository.findByRootCategoryIdOrderByCreateTime(cid, page);
        } else {
            return spuRepository.findByCategoryIdOrderByCreateTimeDesc(cid, page);
        }
    }
}
