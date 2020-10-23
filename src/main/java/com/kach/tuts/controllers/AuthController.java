package com.kach.tuts.controllers;

import com.kach.tuts.security.jwt.JwtConfig;
import com.kach.tuts.services.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    SecretKey secretKey;

    @Autowired
    JwtConfig jwtConfig;

    @Autowired
    AuthenticationManager authenticationManager;

    @PreAuthorize("isAnonymous()")
    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody Map<String, String> body) {
        userService.createUser(body.get("username"), body.get("password"));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);

        Authentication authenticate = authenticationManager.authenticate(authentication);

        Map<String, String> response = new HashMap<>();
        response.put("token", generateToken(username));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/test")
    public ResponseEntity test() {

        return ResponseEntity.ok(HttpStatus.OK);
    }

    private String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
//                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtConfig.getTokenExpirationAfterDays())))
                .signWith(secretKey)
                .compact();
    }
}
