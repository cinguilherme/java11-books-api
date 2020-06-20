package com.gcc.coreapi.books.repository;


import com.gcc.coreapi.books.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Query(
            value = "select * from book where name = :name",
            nativeQuery = true
    )
    Optional<Book> findBookByName(@Param("name") String name);

}
