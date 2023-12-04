package com.example.demo.repositories;

import com.example.demo.collections.Catalogue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatalogueRepository extends MongoRepository<Catalogue, String> {
    Optional<List<Catalogue>> findAllByTechnologyId(String id);

    @Query(value = "{ 'technologyId' : ?0 }", fields = "{ 'title' : 1, '_id' : 1}")
    Optional<List<Catalogue>> findTitleAndIdByTechnologyId(String technologyId);
}
