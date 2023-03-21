package com.login.Software.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@AllArgsConstructor
@Document(collection = "user")
@NoArgsConstructor
public class User {

    @Id
    private String userId;
    private String username;
    private String password;
    public User(Map<String, Object> data) {
    }
}
