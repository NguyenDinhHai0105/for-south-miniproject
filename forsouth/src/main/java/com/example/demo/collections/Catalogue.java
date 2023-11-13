package com.example.demo.collections;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

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
    private LocalDate createdDate = LocalDate.now();
    @LastModifiedDate
    private LocalDate lastModifiedDate = LocalDate.now();

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public void setTechnologyId(String technologyId) {
        if (technologyId != null) {
            this.technologyId = technologyId;
        }
    }

}
