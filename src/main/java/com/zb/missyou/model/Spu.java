package com.zb.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Spu {
    @Id
    private Long id;
    private String title;
    private String subtitle;
    private Long categoryId;
    private Integer rootCategoryId;
    private byte online;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
    private String price;
    private Integer sketchSpecId;
    private Integer defaultSkuId;
    private String img;
    private String discountPrice;
    private String description;
    private String tags;
    private Byte isTest;
    private Object spuThemeImg;
    private String forThemeImg;
}
