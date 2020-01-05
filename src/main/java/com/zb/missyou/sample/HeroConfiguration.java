package com.zb.missyou.sample;

import com.zb.missyou.sample.condtion.DianaCondition;
import com.zb.missyou.sample.hero.Camile;
import com.zb.missyou.sample.hero.Diana;
import com.zb.missyou.sample.hero.Lrelia;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeroConfiguration {

   @Bean
//   @Conditional(DianaCondition.class)
   @ConditionalOnProperty(value = "hero.condition", havingValue = "diana")
    public ISkill diana() {
        return new Diana("zb", "18");
    }

    @Bean
    @ConditionalOnProperty(value = "hero.condition", havingValue = "lrelia")
    public ISkill lrelia() {
        return new Lrelia("zb1", "181");
    }
}
