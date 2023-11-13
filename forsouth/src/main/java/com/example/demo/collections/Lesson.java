package com.example.demo.collections;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("lesson")
public class Lesson {
    @Id
    private String id;
    private String title;
    private String catalogueId;
    private String htmlContent;

    @CreatedDate
    private LocalDate createdDate = LocalDate.now();
    @LastModifiedDate
    private LocalDate lastModifiedDate = LocalDate.now();
    @LastModifiedBy
    private String userName;

    public void setTitle(String title) {
        if (title != null) {
            this.title = title;
        }
    }

    public void setCatalogueId(String catalogueId) {
        if (catalogueId != null) {
            this.catalogueId = catalogueId;
        }
    }

    public void setHtmlContent(String htmlContent) {
        if (catalogueId != null) {
            this.htmlContent = htmlContent;
        }
    }
}
