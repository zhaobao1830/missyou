package com.zb.missyou.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Banner {
    @Id
    private String id;
    private String name;
    private String description;
    private String img;
    private String title;
}
