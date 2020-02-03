package com.zb.missyou.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

// 数据传输对象
@Data
public class PersonDTO {
    @NonNull
    private String name;
    private Integer age;
}

