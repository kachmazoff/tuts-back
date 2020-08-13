package com.kach.tuts.domain;

import lombok.*;
import javax.persistence.*;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tutorial_steps")
public class TutorialStep extends BaseEntity {
    @NonNull
    @Column
    private String title;

    @NonNull
    @Column
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tutorial tutorial;
}
