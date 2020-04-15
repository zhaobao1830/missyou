package com.zb.missyou.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Banner {
    // 这是表的主键
    @Id
    private String id;
    @Column(length = 16)
    private String name;
    private String description;
    private String img;
    private String title;
}
