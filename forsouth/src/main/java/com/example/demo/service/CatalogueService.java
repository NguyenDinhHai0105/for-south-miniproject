package com.example.demo.service;

import com.example.demo.collections.Catalogue;

import java.util.List;

public interface CatalogueService {
    void addCatalogue(Catalogue Catalogue);
    Catalogue updateCatalogue(Catalogue Catalogue);
    void deleteCatalogue(String id);
    Catalogue getCatalogueById(String id);
    List<Catalogue> getAllCatalogue();
    List<Catalogue> getCataloguesOfATechnology(String technologyId);
    List<Catalogue> getAllTitleAndIdOfCataloguesOfATechnology(String technologyId);

}
