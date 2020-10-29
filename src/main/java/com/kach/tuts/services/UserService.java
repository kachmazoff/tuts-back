package com.kach.tuts.services;

import com.kach.tuts.dto.UserDTO;
import com.kach.tuts.models.User;

public interface UserService {
    /**
     * Создание нового пользователя
     *
     * @param username Юзернейм пользователя
     * @param password Пароль пользователя
     */
    void createUser(String username, String password);

    /**
     * Поиск пользователя по его юзернейму
     *
     * @param username Юзернейм пользователя
     * @return Объект User найденного пользоваетеля
     */
    User getUser(String username);

    /**
     * Поиск пользователя по его ID
     *
     * @param id ID пользователя
     * @return Объект User найденного пользоваетеля
     */
    User getUser(Long id);

    /**
     * Изменение пароля пользователя
     *
     * @param username    Юзернейм пользователя
     * @param oldPassword Текущий пароль
     * @param newPassword Новый пароль
     */
    void changePassword(String username, String oldPassword, String newPassword);

    /**
     * Обновление данных о пользователе (ФИО)
     * @param dto
     */
    void updateProfileData(User user, UserDTO dto);
}
