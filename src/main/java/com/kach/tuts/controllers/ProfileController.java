package com.kach.tuts.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public ResponseEntity<Map<String, String>> getProfileData() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Map<String, String> result = new HashMap<>();
        result.put("username", authentication.getName());

        return ResponseEntity.ok(result);
    }
}
