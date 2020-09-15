package com.kach.tuts.repositories;

import com.kach.tuts.dto.TutorialStepDTO;
import com.kach.tuts.models.EntityStatus;
import com.kach.tuts.models.TutorialStep;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialStepRepository extends CrudRepository<TutorialStep, Long> {
    /**
     * Получение всех шагов туториалов с заданным статусом
     * @param status Статус
     * @return Список шагов туториалов
     */
    Iterable<TutorialStep> findAllByStatus(EntityStatus status);

//    List<TutorialStepDTO> findAllByTutorial_Id(Long tutorialId);
    List<TutorialStep> findAllByTutorial_Id(Long tutorialId);
}
