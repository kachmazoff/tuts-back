package com.kach.tuts.dto;

import com.kach.tuts.models.Tutorial;
import com.kach.tuts.models.User;
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
    UserDTO author;

    public TutorialPreviewDTO(Tutorial tutorial) {
        this.id = tutorial.getId();
        this.title = tutorial.getTitle();
        this.description = tutorial.getDescription();
        this.isDraft = tutorial.getIsDraft();
        this.isPublic = tutorial.getIsPublic();
        this.author = new UserDTO(tutorial.getAuthor());
    }
}
