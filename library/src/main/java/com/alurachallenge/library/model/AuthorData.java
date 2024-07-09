package com.alurachallenge.library.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorData(
        String name,
        @JsonAlias("birth_year") String yearOfBirth,
        @JsonAlias("death_year") String yearOfDeath) {


    @Override
    public String toString() {
        return "AuthorData{" +
                "name='" + name + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", yearOfDeath='" + yearOfDeath + '\'' +
                '}';
    }
}
