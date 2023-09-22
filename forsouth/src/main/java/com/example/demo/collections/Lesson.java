package com.example.demo.collections;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

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

    @CreatedDate
    private Date createdDate;

}
