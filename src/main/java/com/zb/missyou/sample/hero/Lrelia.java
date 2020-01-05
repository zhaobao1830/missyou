package com.zb.missyou.sample.hero;

import com.zb.missyou.sample.ISkill;
import org.springframework.stereotype.Component;

//@Component 使用了@Configuration和@bean，这个就可以先隐藏
public class Lrelia implements ISkill {
    private String name;
    private String age;

    @Override
    public void q() {
        System.out.println("Lrelia q");
    }

    public Lrelia() {
        System.out.println("Diana");
    }

    public Lrelia(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
