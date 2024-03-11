package com.example.demo.repositories;

import com.example.demo.collections.FileData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends MongoRepository<FileData, String> {
}
