package com.zb.missyou.dto;

import com.zb.missyou.validators.PasswordEqual;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

// 数据传输对象
@Getter
@Setter
@PasswordEqual(min = 1, message = "俩次密码不一样")
public class PersonDTO {
    @Length(min = 2, max = 10, message = "名字个数大于1小于10")
    private String name;
    private Integer age;
    private String password1;
    private String password2;
}

