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
@Table(name = "tutorial")
public class Tutorial extends BaseEntity{
    @NonNull
    @Column
    private String title;

    @NonNull
    @Column
    private String description;
}
