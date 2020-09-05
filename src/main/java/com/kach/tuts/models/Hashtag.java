package com.kach.tuts.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "hashtags")
public class Hashtag extends BaseEntity {
    @NotNull
    @Column(name = "name")
    String name;

    public Hashtag() { }

    public Hashtag(String newName) {
        name = newName;
    }
}
