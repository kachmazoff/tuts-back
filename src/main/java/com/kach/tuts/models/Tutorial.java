package com.kach.tuts.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tutorials")
public class Tutorial extends BaseEntity {
    @NotNull
    String title;

    @NotNull
    @Column(columnDefinition = "LONGTEXT")
    String description;

    @NotNull
    @Column(columnDefinition = "boolean default true")
    Boolean isDraft = true;

    @NotNull
    @Column(columnDefinition = "boolean default true")
    Boolean isPublic = true;

    public Tutorial(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Tutorial(String title, String description, Boolean isDraft) {
        this.title = title;
        this.description = description;
        this.isDraft = isDraft;
    }

    public Tutorial(String title, String description, Boolean isDraft, Boolean isPublic) {
        this.title = title;
        this.description = description;
        this.isDraft = isDraft;
        this.isPublic = isPublic;
    }
}
