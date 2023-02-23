package com.login.Software.repository;

import com.login.Software.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {



    @Query("{username: ?0 }")
    List<User> getUserByUsername(String username);
    @Query("{password: ?0}")
    List<User> getUserByPassword(String password);


}
