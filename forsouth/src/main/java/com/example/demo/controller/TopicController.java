package com.example.demo.controller;

import com.example.demo.collections.Topic;
import com.example.demo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/topic")
public class TopicController {

    @Autowired
    TopicService topicService;

    @PostMapping
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<Topic> addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
        return new ResponseEntity<>(topic, HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic) {
        return new ResponseEntity<>(topicService.updateTopic(topic), HttpStatus.OK);
    }

    @DeleteMapping()
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<Map<String, Boolean>> deleteTopic(@Nullable @RequestParam String topicId) {
        topicService.deleteTopic(topicId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{topicId}")
    public ResponseEntity<Topic> getTopicById(@PathVariable @NotNull String topicId) {
        return new ResponseEntity<>(topicService.getTopicById(topicId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Topic>> getAllTopic() {
        return new ResponseEntity<>(topicService.getAllTopic(), HttpStatus.OK);
    }

    @GetMapping("/test")
    public String test() {
        return "new sdbasijhdfbaidfiuasdf";
    }
}
