package com.kach.tuts.controllers;

import com.kach.tuts.dto.UserDTO;
import com.kach.tuts.models.User;
import com.kach.tuts.services.AuthService;
import com.kach.tuts.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    AuthService authService;

    @Autowired
    UserService userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public ResponseEntity<UserDTO> getProfileData() {
        User user = authService.getActiveUser();
        return ResponseEntity.ok(new UserDTO(user));
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public ResponseEntity<HttpStatus> updateProfileData(@RequestBody UserDTO dto) {
        User u = authService.getActiveUser();
        if (!u.getId().equals(dto.getId())) {
            return ResponseEntity.ok(HttpStatus.FORBIDDEN);
        }
        userService.updateProfileData(u, dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
