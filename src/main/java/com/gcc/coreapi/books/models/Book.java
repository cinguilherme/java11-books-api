package com.gcc.coreapi.books.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Book {

    private @Id @GeneratedValue Long id;

    private String name;

    Book() {}

    Book(String name) {
        this.name = name;
    }
}
