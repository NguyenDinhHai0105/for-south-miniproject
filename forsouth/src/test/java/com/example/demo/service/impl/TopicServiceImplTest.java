package com.example.demo.service.impl;

import com.example.demo.collections.Topic;
import com.example.demo.repositories.TopicRepository;
import com.example.demo.service.TopicService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TopicServiceImplTest {

    private final String TOPIC_ID = "1";
    private final String TOPIC_NAME = "name";
    private final String TOPIC_DESCRIPTION = "des";
    private final LocalDate TOPIC_CREATED_DATE = LocalDate.parse("1970-01-01");
    private final LocalDate TOPIC_LAST_MODIFIED_DATE = LocalDate.parse("9999-12-31");;

    private Topic topic;

    @Mock
    TopicService topicService;

    @Mock
    TopicRepository topicRepository;

    @InjectMocks
    TopicServiceImpl topicServiceImpl;

    @BeforeEach
    void setUp() {
        this.topic = new Topic(TOPIC_ID, TOPIC_NAME, TOPIC_DESCRIPTION, TOPIC_CREATED_DATE, TOPIC_LAST_MODIFIED_DATE);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void should_ReturnTopic_WhenSaveTopic() {
        //given
        Topic expectedTopic = new Topic(TOPIC_ID, TOPIC_NAME, TOPIC_DESCRIPTION, TOPIC_CREATED_DATE, TOPIC_LAST_MODIFIED_DATE);
        when(topicRepository.save(topic)).thenReturn(expectedTopic);

        //when
        topicServiceImpl.addTopic(topic);

        //then
        assertAll(
                () -> assertEquals(expectedTopic.getId(), topic.getId()),
                () -> assertEquals(expectedTopic.getName(), topic.getName()),
                () -> assertEquals(expectedTopic.getDescription(), topic.getDescription()),
                () -> assertEquals(expectedTopic.getCreatedDate(), topic.getCreatedDate()),
                () -> assertEquals(expectedTopic.getLastModifiedDate(), topic.getLastModifiedDate())
        );
    }

    @Test
    void updateTopic() {
    }

    @Test
    void deleteTopic() {
    }

    @Test
    void getTopicById() {
    }

    @Test
    void getAllTopic() {
    }
}