package com.example.demo.service.impl;

import com.example.demo.collections.Catalogue;
import com.example.demo.repositories.CatalogueRepository;
import com.example.demo.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogueServiceImpl implements CatalogueService {

    @Autowired
    private CatalogueRepository catalogueRepository;
    public void saveCatalogue(Catalogue catalogue) {
        catalogueRepository.save(catalogue);
    }
}
