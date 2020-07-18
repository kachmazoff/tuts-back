package com.kach.tuts.domain;

import lombok.*;
import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
//@AllArgsConstructor // ??
@Entity
@Table(name = "tutorial_steps")
public class TutorialStep extends BaseEntity {
    @NonNull
    @Column
    String title;

    @NonNull
    @Column
    String body;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TutorialStep that = (TutorialStep) o;
        return title.equals(that.title) &&
                body.equals(that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, body);
    }
}
