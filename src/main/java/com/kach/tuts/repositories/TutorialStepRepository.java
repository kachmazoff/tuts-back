package com.kach.tuts.repositories;

import com.kach.tuts.models.EntityStatus;
import com.kach.tuts.models.TutorialStep;
import org.springframework.data.repository.CrudRepository;

public interface TutorialStepRepository extends CrudRepository<TutorialStep, Long> {
    /**
     * Получение всех шагов туториалов с заданным статусом
     * @param status Статус
     * @return Список шагов туториалов
     */
    Iterable<TutorialStep> findAllByStatus(EntityStatus status);
}
