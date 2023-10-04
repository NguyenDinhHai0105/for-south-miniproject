package com.example.demo.service;

import com.example.demo.collections.Technology;

import java.util.List;

public interface TechnologyService {
    void addTechnology(Technology Technology);
    Technology updateTechnology(Technology Technology);
    void deleteTechnology(String id);
    Technology getTechnologyById(String id);
    List<Technology> getAllTechnology();
}
