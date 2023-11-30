package com.example.demo.controller;

import com.example.demo.collections.Lesson;
import com.example.demo.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/lessons")
public class LessonController {

    private LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping
    public ResponseEntity<Lesson> addNewLesson(@RequestBody Lesson lesson) {
        lessonService.addLesson(lesson);
        return new ResponseEntity<>(lesson, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable String id) {
        return new ResponseEntity<>(lessonService.getLessonById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLessonById(@PathVariable @Nullable String id) {
        lessonService.deleteLesson(id);
        return new ResponseEntity<>("Lesson deleted successfully !", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Lesson> updateExistingLesson(@RequestBody Lesson lesson) {
        lessonService.updateLesson(lesson);
        return new ResponseEntity<>(lesson, HttpStatus.OK);
    }
}
