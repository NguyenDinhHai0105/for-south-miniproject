package com.example.demo.controller;


import com.example.demo.collections.Technology;
import com.example.demo.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/technologies")
public class TechnologyController {
    @Autowired
    TechnologyService technologyService;

    @PostMapping
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<Technology> addTechnology(@RequestBody Technology technology) {
        technologyService.addTechnology(technology);
        return new ResponseEntity<>(technology, HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<Technology> updateTechnology(@RequestBody Technology technology) {
        return new ResponseEntity<>(technologyService.updateTechnology(technology), HttpStatus.OK);
    }

    @DeleteMapping()
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<Map<String, Boolean>> deleteTechnology(@Nullable @RequestParam String technologyId) {
        technologyService.deleteTechnology(technologyId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

//    @GetMapping("/{technologyId}")
//    public ResponseEntity<Technology> getTechnologyById(@PathVariable @NotNull String technologyId) {
//        return new ResponseEntity<>(technologyService.getTechnologyById(technologyId), HttpStatus.OK);
//    }

    @GetMapping("/technologies-by-topic-id/{topicId}")
    public ResponseEntity<List<Technology>> getAllTechnologyByTopicId(@PathVariable String topicId) {
        return new ResponseEntity<>(technologyService.getAllTechnologyByTopicId(topicId), HttpStatus.OK);
    }

}
