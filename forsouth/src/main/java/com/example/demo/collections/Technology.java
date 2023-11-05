package com.example.demo.collections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("technology")
public class Technology {

    @Id
    private String id;
    private String name;
    private String icon;
    private String description;
    private String topicId;
    @CreatedDate
    private LocalDate createdDate = LocalDate.now();
    @LastModifiedDate
    private LocalDate lastModifiedDate = LocalDate.now();

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public void setIcon(String icon) {
        if (icon != null) {
            this.icon = icon;
        }
    }

    public void setDescription(String description) {
        if (description != null) {
            this.description = description;
        }
    }
}
