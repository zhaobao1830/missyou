package com.zb.missyou.validators;

import com.zb.missyou.dto.PersonDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// 参数 泛型 第一个指定自定义注解的类型 第二个指定PasswordEqual修饰的目标的类型（如果修饰的是String name，那么类型就是String）
public class PasswordValidator implements ConstraintValidator<PasswordEqual, PersonDTO> {
    private int max;
    private int min;

    // 用来获取注解传入的参数
    @Override
    public void initialize(PasswordEqual constraintAnnotation) {
        this.max = constraintAnnotation.max();
        this.min = constraintAnnotation.min();
    }

    // 用来对值进行校验
    @Override
    public boolean isValid(PersonDTO personDTO, ConstraintValidatorContext context) {
        String password1 = personDTO.getPassword1();
        String password2 = personDTO.getPassword2();
        boolean match = password1.equals(password2);
        return match;
    }
}
