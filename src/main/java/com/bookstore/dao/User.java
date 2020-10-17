package com.bookstore.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String firstname;
    private String lastname;
    private Date birthday;
    private Date rgDate;
    private String img;

}
