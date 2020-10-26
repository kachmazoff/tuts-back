package com.kach.tuts.services;

import com.kach.tuts.models.User;

import java.util.Optional;

public interface AuthService {
    /**
     * Возвращает уникальный username авторизованного пользователя
     * @return username текущего пользователя
     */
    String getActiveUserUsername();

    /**
     * Возвращает модель авторизованного пользователя
     * @return Объект текущего пользователя
     */
    User getActiveUser();

    boolean isAuthenticated();
}
