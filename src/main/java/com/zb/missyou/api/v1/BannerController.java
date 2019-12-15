package com.zb.missyou.api.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/v1/banner")
public class BannerController {

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public String test() {
        return "Hello,zhaobao1830";
    }
}
