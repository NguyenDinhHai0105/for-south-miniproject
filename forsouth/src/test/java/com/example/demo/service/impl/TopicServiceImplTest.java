package com.example.demo.service.impl;

import com.example.demo.collections.Topic;
import com.example.demo.repositories.TopicRepository;
import com.example.demo.service.TopicService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @DisplayName("Test save a topic successfully")
    @Test
    void should_ReturnTopic_WhenSaveTopic() {
        //when
        topicServiceImpl.addTopic(topic);
        //then
        verify(topicRepository, times(1)).save(topic); //why ? because save() method of MongoRepository was tested. Only confirm it was called
    }

    @DisplayName("Test update topic method successfully")
    @Test
    void should_ReturnUpdatedTopic_WhenUpdateTopic() {
        //given
        Topic existingTopic = new Topic(TOPIC_ID, TOPIC_NAME, TOPIC_DESCRIPTION, TOPIC_CREATED_DATE, TOPIC_LAST_MODIFIED_DATE);
        existingTopic.setName("updated name");
        existingTopic.setDescription("updated description");
        when(topicRepository.findById(existingTopic.getId())).thenReturn(Optional.of(existingTopic));
        
        //when
        Topic expectedTopic = topicServiceImpl.updateTopic(existingTopic);
        
        //then
        assertAll(
                () -> assertEquals(expectedTopic.getId(), existingTopic.getId()),
                () -> assertEquals(expectedTopic.getName(), existingTopic.getName()),
                () -> assertEquals(expectedTopic.getDescription(), existingTopic.getDescription()),
                () -> assertEquals(expectedTopic.getCreatedDate(), existingTopic.getCreatedDate()),
                () -> assertEquals(expectedTopic.getLastModifiedDate(), existingTopic.getLastModifiedDate())
        );

    }

    @DisplayName("Delete a topic successfully")
    @Test
    void deleteTopic() {
        //given
        when(topicRepository.findById(TOPIC_ID)).thenReturn(Optional.ofNullable(topic));

        //when
        topicServiceImpl.deleteTopic(TOPIC_ID);
        topicServiceImpl.deleteTopic(null);

        //then
        verify(topicRepository, times(1)).deleteById(TOPIC_ID);
        verify(topicRepository, times(1)).deleteAll();
    }

    @Test
    void getTopicById() {
    }

    @Test
    void getAllTopic() {
    }
}