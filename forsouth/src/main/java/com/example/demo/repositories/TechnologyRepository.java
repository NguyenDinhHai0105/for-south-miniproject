package com.example.demo.repositories;

import com.example.demo.collections.Technology;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TechnologyRepository extends MongoRepository<Technology, String> {
}
