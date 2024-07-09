package com.alurachallenge.library.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
        @JsonAlias("title") String title,
        @JsonAlias("authors") List<Author> author,
        @JsonAlias("languages")List<String> languajes,
        @JsonAlias("download_count") Double downloads) {


    @Override
    public String toString() {
        return "------- BOOK ------\n" +
                "Title: " + title + '\n' +
                "Author: " + author.get(0).getName() + "\n"+
                "Languages: " + languajes + "\n"+
                "Downloads: " + downloads + "\n" +
                "------------------\n";
    }
}

