package com.zb.missyou.sample;

import com.zb.missyou.sample.hero.Camile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeroConfiguration {

   @Bean
    public ISkill camile() {
        return new Camile();
    }
}
