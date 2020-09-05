package com.kach.tuts.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "tutorial_steps")
public class TutorialStep extends BaseEntity {
    @NotNull
    String title;

    @NotNull
    @Column(columnDefinition = "LONGTEXT")
    String body;

    public TutorialStep(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
