package com.alurachallenge.library.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Author> author;
    private List<String> languajes;
    private Double downloads;

    
    public Book(){}

    public Book(Data foundData) {
    }

    public Book(BookData bookData) {
        this.title = bookData.title();
//        this.author = bookData.author();
        this.languajes = bookData.languajes();
        this.downloads = bookData.downloads();

        this.author = bookData.author().stream()
                .map(authorData -> new Author(authorData, this))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "------- BOOK ------\n" +
                "Title: " + title + '\n' +
                "Author: " + author.get(0).getName() + "\n"+
                "Languages: " + languajes + "\n"+
                "Downloads: " + downloads + "\n" +
                "------------------\n";
    }

    //Getters and Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public List<String> getLanguages() {
        return languajes;
    }

    public void setLanguages(List<String> languages) {
        this.languajes = languages;
    }

    public Double getDownloads() {
        return downloads;
    }

    public void setDownloads(Double downloads) {
        this.downloads = downloads;
    }
}

