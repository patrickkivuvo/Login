package com.login.Software.service;

import com.login.Software.model.User;
import com.login.Software.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    //CRUD CREATE, READ, UPDATE, DELETE

    public User addUser(User user){
        user.setUserId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(user);
    }



    public User getUserByUserId(String userId){
        return repository.findById(userId).get();
    }


    public List<User> getUserByUsername(String username){
        return repository.getUserByUsername(username);
    }
    public List<User> getUserByPassword(String password){
        return repository.getUserByPassword(password);
    }


    public List<User> findAllUsers(){
        return repository.findAll();
    }

    public User updateUser(User userRequest){
        //get the existing document from DB
        //populate new value from request to existing object/entity/document
        User existingUser = repository.findById(userRequest.getUserId()).get();
        existingUser.setUsername(userRequest.getUsername());
        existingUser.setPassword(userRequest.getPassword());
                return repository.save(existingUser);
    }


    public String deleteUser(String userId){
        repository.deleteById(userId);
        return userId + " User deleted from dashboard";
    }


    public User deleteById(String id) {

        return null;
    }
}
