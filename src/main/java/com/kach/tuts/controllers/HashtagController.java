package com.kach.tuts.controllers;

import com.kach.tuts.models.Hashtag;
import com.kach.tuts.services.HashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/hashtags")
public class HashtagController {
    @Autowired
    HashtagService hashtagService;

    @GetMapping
    List<Hashtag> getAllHashtags() {
        return hashtagService.getAll();
    }

    @PostMapping
    ResponseEntity createHashtag(@RequestBody Map<String, String> body ) {
        hashtagService.create(body.get("name"));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteHashtag(@PathVariable("id") Long id) {
        hashtagService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
