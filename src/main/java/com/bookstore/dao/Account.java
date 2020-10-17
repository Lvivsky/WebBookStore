package com.bookstore.dao;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {

    private Long id;
    private String email;
    private String password;

}
