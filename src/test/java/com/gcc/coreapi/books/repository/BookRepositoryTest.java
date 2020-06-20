package com.gcc.coreapi.books.repository;

import com.gcc.coreapi.books.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=create-drop",
        "spring.flyway.enabled=false"
})
class BookRepositoryTest {

    public static final String THE_LORD_OF_THE_RINGS = "the lord of the rings";
    public static final String LOLITA = "Lolita";
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setupBasic() {
        Book lolita = Book.builder().name(LOLITA).build();
        Book lotr = Book.builder().name(THE_LORD_OF_THE_RINGS).build();

        bookRepository.save(lolita);
        bookRepository.save(lotr);
    }

    @Test
    void injectedComponentsAreNotNull() {

        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(bookRepository).isNotNull();
    }

    @Test
    void shouldGetTheSingleBookInDb() {
        Optional<Book> bookByName = bookRepository.findBookByName(THE_LORD_OF_THE_RINGS);
        assertThat(bookByName).isNotEmpty();
        bookByName.ifPresent(book1 ->
                assertThat(book1.getName()).isEqualTo(THE_LORD_OF_THE_RINGS)
        );
    }

    @Test
    void shouldFindLolitaAndLOTR() {
        List all = (List) bookRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

    }
}