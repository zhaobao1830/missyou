package com.zb.missyou.sample.condtion;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DianaCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // context用来获取项目中其他文件的配置
        // hero.condition这是application.properties里的值
        String name = context.getEnvironment().getProperty("hero.condition");

        // 返回true就可以
        return "irelia".equalsIgnoreCase(name);
    }
}
