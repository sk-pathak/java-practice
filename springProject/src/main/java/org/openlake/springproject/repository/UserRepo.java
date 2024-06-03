package org.openlake.springproject.repository;

import org.openlake.springproject.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,String> {

}
