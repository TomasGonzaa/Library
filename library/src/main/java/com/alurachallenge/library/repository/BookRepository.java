package com.alurachallenge.library.repository;

import com.alurachallenge.library.model.Author;
import com.alurachallenge.library.model.AuthorData;
import com.alurachallenge.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("SELECT a FROM Author a WHERE a.yearOfDeath > :yearSearch ")
    List<Author> livingAuthorsbyYear(String yearSearch);

    @Query("SELECT b From Book b WHERE b.languajes IN :language")
    List<Book> booksByLanguage(List<String> language);
}
