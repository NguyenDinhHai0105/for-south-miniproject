package com.example.demo.service;

import com.example.demo.collections.Lesson;

import java.util.List;

public interface LessonService {
    void addLesson(Lesson Lesson);
    Lesson updateLesson(Lesson Lesson);
    void deleteLesson(String id);
    Lesson getLessonById(String id);
    List<Lesson> getAllLesson();
}
