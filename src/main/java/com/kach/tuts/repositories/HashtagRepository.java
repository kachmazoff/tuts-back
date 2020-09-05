package com.kach.tuts.repositories;

import com.kach.tuts.models.EntityStatus;
import com.kach.tuts.models.Hashtag;
import org.springframework.data.repository.CrudRepository;

public interface HashtagRepository extends CrudRepository<Hashtag, Long> {
    /**
     * Получение всех хэштегов с заданным статусом
     * @param status Статус
     * @return Список хэштегов
     */
    Iterable<Hashtag> findAllByStatus(EntityStatus status);
}
