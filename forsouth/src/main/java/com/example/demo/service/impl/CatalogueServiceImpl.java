package com.example.demo.service.impl;

import com.example.demo.collections.Catalogue;
import com.example.demo.repositories.CatalogueRepository;
import com.example.demo.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueServiceImpl implements CatalogueService {

    @Autowired
    private CatalogueRepository catalogueRepository;
    public void saveCatalogue(Catalogue catalogue) {
        catalogueRepository.save(catalogue);
    }

    @Override
    public void addCatalogue(Catalogue Catalogue) {

    }

    @Override
    public Catalogue updateCatalogue(Catalogue Catalogue) {
        return null;
    }

    @Override
    public void deleteCatalogue(String id) {

    }

    @Override
    public Catalogue getCatalogueById(String id) {
        return null;
    }

    @Override
    public List<Catalogue> getAllCatalogue() {
        return null;
    }
}
