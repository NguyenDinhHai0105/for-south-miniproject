package com.example.demo.collections;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Document("topic")
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    @Id
    private String id;
    @NotNull
    private String name;
    private List<Technology> technologies;
    @CreatedDate
    private Date createdDate = new Date();
    @LastModifiedDate
    private Date lastModifiedDate = new Date();
}
