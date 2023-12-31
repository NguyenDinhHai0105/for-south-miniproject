package com.example.demo.repositories;

import com.example.demo.collections.Catalogue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogueRepository extends MongoRepository<Catalogue, String> {
}
