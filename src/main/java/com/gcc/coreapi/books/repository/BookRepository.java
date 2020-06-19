package com.gcc.coreapi.books.repository;


import com.gcc.coreapi.books.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
