package com.kach.tuts.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tutorial")
public class Tutorial extends BaseEntity{
    @NonNull
    @Column
    String title;

    @NonNull
    @Column
    String description;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "tutorial_hasgtag",
            joinColumns = {@JoinColumn(name = "tutorial_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "hashtag_id", referencedColumnName = "id")}
    )
    private List<Hashtag> hashtagList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tutorial that = (Tutorial) o;
        return title.equals(that.title) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description);
    }

    public void setHashtagList(List<Hashtag> hashtags){ hashtagList=hashtags; }
}
