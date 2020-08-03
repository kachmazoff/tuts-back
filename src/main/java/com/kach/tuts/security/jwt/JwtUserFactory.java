package com.kach.tuts.security.jwt;

import com.kach.tuts.domain.EntityStatus;
import com.kach.tuts.domain.User;

public final class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getStatus().equals(EntityStatus.ACTIVE),
                user.getUpdated()
        );
    }
}
