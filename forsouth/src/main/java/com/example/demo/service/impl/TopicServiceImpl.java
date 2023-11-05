package com.example.demo.service.impl;

import com.example.demo.collections.Topic;
import com.example.demo.exception.ExceptionMessage;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.TopicRepository;
import com.example.demo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TopicServiceImpl implements TopicService {


    @Autowired
    TopicRepository topicRepository;

    @Override
    public void addTopic(Topic topic) {
        topic.setId(UUID.randomUUID().toString().split("-")[0]);
        topicRepository.save(topic);
    }

    @Override
    public Topic updateTopic(Topic topic) {
        Topic existingTopic = topicRepository.findById(topic.getId()).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.ID_NOT_FOUND + topic.getId())
        );
        existingTopic.setName(topic.getName());
        existingTopic.setDescription(topic.getDescription());
        existingTopic.setLastModifiedDate(topic.getLastModifiedDate());
        topicRepository.save(existingTopic);
        return existingTopic;
    }

    @Override
    public void deleteTopic(String id) {
        if (id == null) {
          topicRepository.deleteAll();
        } else {
        topicRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.ID_NOT_FOUND + id));
        topicRepository.deleteById(id);
        }
    }

    @Override
    public Topic getTopicById(String id) {
        return topicRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.ID_NOT_FOUND + id));
    }

    @Override
    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }

}
