package com.zb.missyou.service.impl;

import com.zb.missyou.model.Banner;
import com.zb.missyou.repository.BannerRepository;
import com.zb.missyou.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    @Override
    public Banner getByName(String name) {
        return bannerRepository.findOneByName(name);
    }
}
