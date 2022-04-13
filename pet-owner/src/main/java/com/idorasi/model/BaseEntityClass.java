package com.idorasi.model;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
abstract class BaseEntityClass implements Serializable {

    @Id
    @GeneratedValue
    protected Long id;

    @Column(name = "creation_datetime")
    protected LocalDateTime creationDateTime;

    @Column(name = "update_datetime")
    protected LocalDateTime updateDateTime;

    @PrePersist
    public void setCreationDateTime() {
        if (this.creationDateTime == null) {
            this.creationDateTime = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void setUpdateDateTime() {
        this.updateDateTime = LocalDateTime.now();
    }
}
