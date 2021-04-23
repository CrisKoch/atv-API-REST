package com.kochmann.service;

public class TodoListItemNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    TodoListItemNaoEncontradoException(Integer id) {
        super("Não encontrei item " + id);
      }

}
