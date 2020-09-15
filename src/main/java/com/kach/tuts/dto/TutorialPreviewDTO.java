package com.kach.tuts.dto;

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
}
