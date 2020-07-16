package com.kach.tuts.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@NoArgsConstructor
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false, unique=true)
    @Getter
    @Setter
    private Long id;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "created")
    @Getter
    @Setter
    private Date created;

    @UpdateTimestamp
    @LastModifiedDate
    @Column(name = "updated")
    @Getter
    @Setter
    private Date updated;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @Getter
    @Setter
    private EntityStatus status = EntityStatus.ACTIVE;
}
