package com.example.demo.service;

import com.example.demo.collections.Topic;

import java.util.List;

public interface TopicService {
    void addTopic(Topic topic);
    Topic updateTopic(Topic topic);
    void deleteTopic(String id);
    Topic getTopicById(String id);
    List<Topic> getAllTopic();
}
