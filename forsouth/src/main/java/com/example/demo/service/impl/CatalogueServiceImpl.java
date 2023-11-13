package com.example.demo.service.impl;

import com.example.demo.collections.Catalogue;
import com.example.demo.exception.ExceptionMessage;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.CatalogueRepository;
import com.example.demo.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CatalogueServiceImpl implements CatalogueService {

    private CatalogueRepository catalogueRepository;

    @Autowired
    public CatalogueServiceImpl(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    @Override
    public void addCatalogue(Catalogue catalogue) {
        catalogue.setId(UUID.randomUUID().toString().split("-")[0]);
        catalogueRepository.save(catalogue);
    }

    @Override
    public Catalogue updateCatalogue(Catalogue catalogue) {
        Catalogue existingCatalogue = catalogueRepository.findById(catalogue.getId()).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.ID_NOT_FOUND + catalogue.getId())
        );
        existingCatalogue.setName(catalogue.getName());
        existingCatalogue.setTechnologyId(catalogue.getTechnologyId());
        existingCatalogue.setLastModifiedDate(catalogue.getLastModifiedDate());
        return existingCatalogue;
    }

    @Override
    public void deleteCatalogue(String id) {
        catalogueRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.ID_NOT_FOUND + id)
        );
        catalogueRepository.deleteById(id);
    }

    @Override
    public Catalogue getCatalogueById(String id) {
        return catalogueRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.ID_NOT_FOUND + id)
        );
    }

    @Override
    public List<Catalogue> getAllCatalogue() {
        return catalogueRepository.findAll();
    }
}
