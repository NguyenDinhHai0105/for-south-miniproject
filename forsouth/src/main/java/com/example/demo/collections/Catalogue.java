package com.example.demo.collections;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("catalogue")
public class Catalogue {
    @Id
    private String id;
    private String name;
    private String technologyId;

    @CreatedDate
    private Date createdDate;
}
