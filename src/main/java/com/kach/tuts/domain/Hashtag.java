package com.kach.tuts.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hashtags")
public class Hashtag extends BaseEntity {
    @NonNull
    @Column
    String name;
}
