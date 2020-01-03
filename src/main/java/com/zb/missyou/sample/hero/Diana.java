package com.zb.missyou.sample.hero;

import com.zb.missyou.sample.ISkill;
import org.springframework.stereotype.Component;

@Component
public class Diana implements ISkill {
    @Override
    public void q(){
        System.out.println("Diana q");
    }
}
