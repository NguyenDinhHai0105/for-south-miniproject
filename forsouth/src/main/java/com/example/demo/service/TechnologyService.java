package com.example.demo.service;

import com.example.demo.collections.Technology;

import java.util.List;

public interface TechnologyService {
    void addTechnology(Technology technology);
    Technology updateTechnology(Technology technology);
    void deleteTechnology(String id);
    Technology getTechnologyById(String id);
    List<Technology> getAllTechnology();
}
