package com.kach.tuts.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tutorial")
public class Tutorial extends BaseEntity{
    @NonNull
    @Column
    private String title;

    @NonNull
    @Column
    private String description;

    @OneToMany(
            mappedBy = "tutorial",
            cascade = CascadeType.ALL
    )
    private List<TutorialStep> tutorialStepList;

    public void addTutorialStep(TutorialStep tutorialStep) {
        this.tutorialStepList.add(tutorialStep);
    }

    public void deleteTutorialStep(TutorialStep tutorialStep) {
        this.tutorialStepList.remove(tutorialStep);
    }
}
