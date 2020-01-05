package com.zb.missyou.api.v1;

import com.zb.missyou.sample.ISkill;
import com.zb.missyou.sample.hero.Diana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/banner")
public class BannerController {
    @Autowired
//    主动注入
    private ISkill iSkill;

//    @Autowired
////    被动注入
//    @Qualifier(value = "diana")
//    private ISkill lreliass;

//    private ISkill camile;
//    @Autowired
//    public void setCamile(ISkill camile) {
//        this.camile = camile;
//    }

//    @Autowired
//    private ISkill camile;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        iSkill.q();
        return "Hello,zhaobao18300";
    }
}
