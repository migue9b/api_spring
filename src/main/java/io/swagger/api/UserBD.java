package io.swagger.api;

import io.swagger.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserBD extends MongoRepository<User, Integer> {

}
