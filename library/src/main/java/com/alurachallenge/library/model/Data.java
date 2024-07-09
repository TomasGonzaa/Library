package com.alurachallenge.library.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Data(

        //para poder a acceder a sub elemento en donde estan los datos de los libros
         List<BookData> results) {
}
