package com.zb.missyou.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
// 用来指定这个自定义校验所关联的类（主要的判断逻辑都在这个类里面）
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordEqual {
    int min() default 1;

    int max() default 10;

    String message() default "passwods are not equal";

    // 写自定义校验注解，固定写法
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
