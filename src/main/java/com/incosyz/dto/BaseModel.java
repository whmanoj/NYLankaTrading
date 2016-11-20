package com.incosyz.dto;

import com.incosyz.entity.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Stelan Briyan on 10/30/2016.
 */
@MappedSuperclass
public class BaseModel implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long Id;

    @Column(columnDefinition = "DATETIME", name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

    @ManyToOne
    @JoinColumn(name = "fk_CREATED_USER")
    private User createdUser;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(User createdUser) {
        this.createdUser = createdUser;
    }
}
