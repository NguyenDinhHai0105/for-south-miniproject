package com.example.demo.controller;

import com.example.demo.collections.Catalogue;
import com.example.demo.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public ResponseEntity<List<Catalogue>> getAllCatalogue() {
        List<Catalogue> catalogues = catalogueServiceImpl.getAllCatalogue();
        return new ResponseEntity<>(catalogues, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Catalogue> addCatalogue(@RequestBody Catalogue catalogue) {
        catalogueServiceImpl.addCatalogue(catalogue);
        return new ResponseEntity<>(catalogue, HttpStatus.OK);
    }
}
