package com.bookstore.model;

import com.bookstore.util.RandomGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String picture;
    private String role;

    public User(String email, String password, String firstName, String lastName, String picture, String role) {
        this.id = RandomGenerator.getRandomID();
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.picture = picture;
        this.role = role;
    }
}
