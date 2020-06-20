package com.gcc.coreapi.books.models;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;
}
