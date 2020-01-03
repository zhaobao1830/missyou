package com.zb.missyou.api.v1;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/banner")
public class BannerController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "Hello,zhaobao18300";
    }
}
