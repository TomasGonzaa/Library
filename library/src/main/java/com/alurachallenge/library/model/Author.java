package com.alurachallenge.library.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "Authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonAlias("name") private String name;
    @JsonAlias("birth_year") private String yearOfBirth;
    @JsonAlias("death_year") private String yearOfDeath;
    @ManyToOne
    private Book book;


//Constructor predeterminado
    public Author(){}


//    public Author(AuthorData authorData) {
//        this.name = authorData.name();
//        this.yearOfBirth = authorData.yearOfBirth();
//        this.yearOfDeath = authorData.yearOfDeath();
//
//    }

    public Author(Author author, Book book) {
        this.name = author.name;
        this.yearOfBirth = author.yearOfBirth;
        this.yearOfDeath = author.yearOfDeath;
        this.setBook(book);
    }


    //Getter y Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getYearOfDeath() {
        return yearOfDeath;
    }

    public void setYearOfDeath(String yearOfDeath) {
        this.yearOfDeath = yearOfDeath;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    //Metodo ToString

    @Override
    public String toString() {
        return  "--------- AUTHOR --------\n" +
                "Name= " + name + '\n' +
                "Year Of Birth= " + yearOfBirth + '\n' +
                "Year Of Death= " + yearOfDeath + '\n' +
                "book= " + (book!=null ? book.getTitle() : "N/A") + "\n"+
                "-------------------------\n";
    }
}

