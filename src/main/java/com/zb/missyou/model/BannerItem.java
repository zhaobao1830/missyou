package com.zb.missyou.model;

import javax.persistence.*;

@Entity
public class BannerItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String img;
    private String keyword;
    private Short type; // 用来判断跳转到哪里 是详情页还是主题页
    private String name;
//    private Long bannerId;

    @ManyToOne
//    @JoinColumn(name = "bannerId")
    private Banner banner;
}
