package com.example.demo.collections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Document("technology")
public class Technology {

    @Id
    private String id;
    private String name;
    private List<Catalogue> catalogues;
    @CreatedDate
    private Date createdDate;

}
