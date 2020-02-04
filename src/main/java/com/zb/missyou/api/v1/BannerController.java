package com.zb.missyou.api.v1;

import com.zb.missyou.dto.PersonDTO;
import com.zb.missyou.exception.http.ForbiddenException;
import com.zb.missyou.exception.http.NotFoundException;
import com.zb.missyou.sample.ISkill;
import com.zb.missyou.sample.hero.Diana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/banner")
public class BannerController {
//    @Autowired
//    主动注入
//    private ISkill iSkill;

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

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public void test(@RequestBody @Validated PersonDTO personDTO) {
        System.out.println(personDTO.getName());
    }
}
