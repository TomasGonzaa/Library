package com.alurachallenge.library.service;

public interface IConvertData {
    //generic code to be able to work with different classes

    <T> T getData(String json, Class<T> classes);
}
