package com.example.demo.collections;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Document("lesson")
public class Lesson {
    @Id
    private String id;
    private String name;
    private String title;
    private String imageUrl;
    private String detail;
    private String catalogueId;
    private List<LessonPart> lessonParts;

    @CreatedDate
    private Date createdDate;

}
