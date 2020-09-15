package com.kach.tuts.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tutorial_steps")
public class TutorialStep extends BaseEntity {
//    @Column(columnDefinition = "integer default 0")
    Integer orderNumber = 0;

    @NotNull
    String title;

    @NotNull
    @Column(columnDefinition = "LONGTEXT")
    String body;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "tutorial_id")
    private Tutorial tutorial;

    public TutorialStep(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
