package com.zb.missyou.api.v1;

import com.zb.missyou.exception.http.NotFoundException;
import com.zb.missyou.model.Banner;
import com.zb.missyou.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Banner getByName(@PathVariable @NotBlank String name) {
        Banner banner = bannerService.getByName(name);
        if (banner == null) {
            throw new NotFoundException(30005);
        }
        return banner;
    }
}
