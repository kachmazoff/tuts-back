package com.kach.tuts.repositories;

import com.kach.tuts.models.Tutorial;
import org.springframework.data.repository.CrudRepository;

public interface TutorialRepository extends CrudRepository<Tutorial, Long> {
}
