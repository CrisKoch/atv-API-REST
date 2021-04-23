package com.kochmann.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kochmann.service.TodoListNaoEncontradoException;

@ControllerAdvice
public class TodoListNaoEncontradoAdvice {
        @ResponseBody
        @ExceptionHandler(TodoListNaoEncontradoException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String employeeNotFoundHandler(TodoListNaoEncontradoException ex) {
                return ex.getMessage();
        }

}
