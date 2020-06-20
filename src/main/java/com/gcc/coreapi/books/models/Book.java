package com.gcc.coreapi.books.models;


import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
@Builder
@Getter
public class Book {

    private @Id
    @GeneratedValue
    Long id;

    private String name;
}
