package com.zb.missyou.service;

import com.zb.missyou.model.Banner;
import org.springframework.stereotype.Service;

@Service
public interface BannerService {
    Banner getByName(String name);
}
