package ru.netology.javaqa.exceptions.services;


public class NotFoundException extends RuntimeException {

    public NotFoundException(String s) {
        super(s);
    }
}
