package com.kdu.smarthome.entities;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @PrePersist
    public void prePersist() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    public void preUpdate() {
        this.modifiedAt = new Timestamp(System.currentTimeMillis());
    }

    @PreRemove
    public void preRemove() {
        this.deletedAt = new Timestamp(System.currentTimeMillis());
    }
}
