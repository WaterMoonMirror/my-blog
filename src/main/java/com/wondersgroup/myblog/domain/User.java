package com.wondersgroup.myblog.domain;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30)
    private String name;

    private Integer age;

    /**
     * 数据库中的Date类型，取到页面上是yyyy-MM-dd hh-mm-ss格式
     * 利用@Temporal则可以获取自己想要的格式类型
     * TIMESTAMP　　yyyy-MM-dd hh:mm:ss 2016-12-07 11:47:58.697这个是会显示到毫秒的
     * DATE　　　　　yyyy-MM-dd
     * TIME　　　　　hh:mm:ss
     *
     * CreationTimestamp 自动添加创建时间
     *
     * UpdateTimestamp  自动添加更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private  Date updateTime;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
