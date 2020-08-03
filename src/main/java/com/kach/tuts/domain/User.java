package com.kach.tuts.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity{
    @NonNull
    @Column
    String username;

    @NonNull
    @Column
    String password;
}