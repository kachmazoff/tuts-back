package com.kach.tuts.dto;

import com.kach.tuts.models.Tutorial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorialPreviewDTO {
    Long id;
    String title;
    String description;
    Boolean isDraft;
    Boolean isPublic;
    Integer stepsCount;

    public TutorialPreviewDTO(Tutorial tutorial) {
        this.id = tutorial.getId();
        this.title = tutorial.getTitle();
        this.description = tutorial.getDescription();
        this.isDraft = tutorial.getIsDraft();
        this.isPublic = tutorial.getIsPublic();
    }
}
