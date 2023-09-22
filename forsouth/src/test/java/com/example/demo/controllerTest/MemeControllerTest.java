package com.example.demo.controllerTest;

import static org.assertj.core.api.Assertions.*;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class MemeControllerTest {

    @Autowired MongoTemplate mongoTemplate;

    @DisplayName("give a subject to save, when save obj using MongoTemplate, then obj is saved")
    @Test
    public void save_an_object_test() {
        // given
        DBObject objectToSave = BasicDBObjectBuilder.start()
                .add("key", "value").get();
        //when
        mongoTemplate.save(objectToSave, "collection");
        //then
        assertThat(mongoTemplate.findAll(DBObject.class, "collection")).extracting("key")
                .containsOnly("value");
    }
}
