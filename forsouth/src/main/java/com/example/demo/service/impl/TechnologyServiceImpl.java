package com.example.demo.service.impl;

import com.example.demo.collections.Technology;
import com.example.demo.exception.ExceptionMessage;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.TechnologyRepository;
import com.example.demo.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    private TechnologyRepository technologyRepository;

    @Autowired
    public TechnologyServiceImpl(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Override
    public void addTechnology(Technology technology) {
        technology.setId(UUID.randomUUID().toString().split("-")[0]);
        technologyRepository.save(technology);
    }

    @Override
    public Technology updateTechnology(Technology technology) {
        Technology existingTechnology = technologyRepository.findById(technology.getId()).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.ID_NOT_FOUND + technology.getId())
        );
        existingTechnology.setName(technology.getName());
        existingTechnology.setIcon(technology.getIcon());
        existingTechnology.setDescription(technology.getDescription());
        existingTechnology.setLastModifiedDate(technology.getLastModifiedDate());
        technologyRepository.save(existingTechnology);
        return existingTechnology;
    }

    @Override
    public void deleteTechnology(String id) {
        if (id == null) {
            technologyRepository.deleteAll();
        } else {
            technologyRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException(ExceptionMessage.ID_NOT_FOUND + id));
            technologyRepository.deleteById(id);
        }
    }

    @Override
    public Technology getTechnologyById(String id) {
        return technologyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.ID_NOT_FOUND + id)
        );
    }

    @Override
    public List<Technology> getAllTechnologyByTopicId(String topicId) {
        return technologyRepository.findAllByTopicId(topicId);
    }
}
