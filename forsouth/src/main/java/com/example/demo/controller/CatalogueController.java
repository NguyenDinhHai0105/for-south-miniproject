package com.example.demo.controller;

import com.example.demo.collections.Catalogue;
import com.example.demo.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/catalogues")
public class CatalogueController {

    private CatalogueService catalogueServiceImpl;

    @Autowired
    public CatalogueController(CatalogueService catalogueServiceImpl) {
        this.catalogueServiceImpl = catalogueServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Catalogue> getCatalogueById(@PathVariable String id) {
        Catalogue catalogue = catalogueServiceImpl.getCatalogueById(id);
        return new ResponseEntity<>(catalogue, HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<List<Catalogue>> getAllCatalogue() {
//        List<Catalogue> catalogues = catalogueServiceImpl.getAllCatalogue();
//        return new ResponseEntity<>(catalogues, HttpStatus.OK);
//    }

    @PostMapping
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<Catalogue> addCatalogue(@RequestBody Catalogue catalogue) {
        catalogueServiceImpl.addCatalogue(catalogue);
        return new ResponseEntity<>(catalogue, HttpStatus.OK);
    }

    @GetMapping("/get-catalogues-of-a-topic/{technologyId}")
    public ResponseEntity<List<Catalogue>> getAllCatalogueOfTechnology(@PathVariable String technologyId) {
        List<Catalogue> catalogues = catalogueServiceImpl.getCataloguesOfATechnology(technologyId);
        return new ResponseEntity<>(catalogues, HttpStatus.OK);
    }

    @GetMapping("/get-title-and-id-of-catalogues-of-a-topic/{technologyId}")
    public ResponseEntity<List<Catalogue>> getTitleAndIdOfCataloguesOfTechnology(@PathVariable String technologyId) {
        List<Catalogue> catalogues = catalogueServiceImpl.getAllTitleAndIdOfCataloguesOfATechnology(technologyId);
        return new ResponseEntity<>(catalogues, HttpStatus.OK);
    }
}
