package com.example.demo.collections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("filedata")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class FileData {
    @Id
    private String id;
    private String name;
    private String type;
    private String filePath;
}
