//package com.example.demo.service.impl;
//
//import com.example.demo.collections.Lesson;
//import com.example.demo.exception.ExceptionMessage;
//import com.example.demo.exception.ResourceNotFoundException;
//import com.example.demo.repositories.LessonRepository;
//import com.example.demo.service.LessonService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class LessonServiceImpl implements LessonService {
//
//    private LessonRepository lessonRepository;
//
//    @Autowired
//    public LessonServiceImpl(LessonRepository lessonRepository) {
//        this.lessonRepository = lessonRepository;
//    }
//
//    @Override
//    public void addLesson(Lesson lesson) {
//        lesson.setId(UUID.randomUUID().toString().split("-")[0]);
//        this.lessonRepository.save(lesson);
//    }
//
//    @Override
//    public Lesson updateLesson(Lesson lesson) {
//        Lesson existingLesson = lessonRepository.findById(lesson.getId()).orElseThrow(
//                () -> new ResourceNotFoundException(ExceptionMessage.ID_NOT_FOUND + lesson.getId())
//        );
//        existingLesson.setTitle(lesson.getTitle());
//        existingLesson.setCatalogueId(lesson.getCatalogueId());
//        existingLesson.setHtmlContent(lesson.getHtmlContent());
//        existingLesson.setLastModifiedDate(lesson.getLastModifiedDate());
//        existingLesson.setUserName(lesson.getUserName());
//        lessonRepository.save(existingLesson);
//        return existingLesson;
//    }
//
//    @Override
//    public void deleteLesson(String id) {
//        lessonRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException(ExceptionMessage.ID_NOT_FOUND + id)
//        );
//        lessonRepository.deleteById(id);
//    }
//
//    @Override
//    public Lesson getLessonById(String id) {
//        return lessonRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException(ExceptionMessage.ID_NOT_FOUND + id)
//        );
//    }
//
//}
