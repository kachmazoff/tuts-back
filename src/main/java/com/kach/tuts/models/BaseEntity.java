package com.kach.tuts.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseEntity {
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false, unique=true)
    private Long id;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "created")
    private Date created;

    @UpdateTimestamp
    @LastModifiedDate
    @Column(name = "updated")
    private Date updated;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EntityStatus status = EntityStatus.ACTIVE;
}
