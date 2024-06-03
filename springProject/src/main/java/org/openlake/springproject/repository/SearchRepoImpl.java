package org.openlake.springproject.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.openlake.springproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepoImpl implements SearchRepo{
    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter converter;

    public List<User> findByText(String text) {
        List<User> users = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("userData");
        MongoCollection<Document> collection = database.getCollection("users");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                                            new Document("text",
                                            new Document("query", text)
                                            .append("path", Arrays.asList("username", "name")))),
                                            new Document("$limit", 5L)));

        result.forEach(document -> users.add(converter.read(User.class,document)));
        return users;
    }
}
