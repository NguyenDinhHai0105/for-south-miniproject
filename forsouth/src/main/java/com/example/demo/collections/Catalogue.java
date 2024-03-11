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
    private String title;
    private String htmlContent;
    private String technologyId;

    @CreatedDate
    private LocalDate createdDate = LocalDate.now();
    @LastModifiedDate
    private LocalDate lastModifiedDate = LocalDate.now();

    public void setTitle(String title) {
        if (title != null) {
            this.title = title;
        }
    }

    public void setTechnologyId(String technologyId) {
        if (technologyId != null) {
            this.technologyId = technologyId;
        }
    }

    public void setHtmlContent(String htmlContent) {
        if (htmlContent != null) {
            this.htmlContent = htmlContent;
        }
    }

}
