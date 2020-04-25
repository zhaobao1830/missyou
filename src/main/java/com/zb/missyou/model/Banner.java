package com.zb.missyou.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Banner {
    // 这是表的主键
    @Id
    // 自增长
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16)
    private String name;

    @Transient
    private String description;
    private String img;
    private String title;

    @OneToMany(mappedBy = "banner")
    private List<BannerItem> items;
}
