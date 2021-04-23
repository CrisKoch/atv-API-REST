package com.kochmann.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.kochmann.domain.TodoList;
import com.kochmann.repository.TodoListRepository;


@Service
public class TodoListService {

        @Autowired
        TodoListRepository repository;

        public List<TodoList> todos() {
                return repository.findAll();
        }

        public TodoList novo(TodoList item) {
                return repository.save(item);
        }

        public TodoList pessoa(Integer id) {
                return repository.findById(id).orElseThrow(() -> new TodoListItemNaoEncontradoException(id));
        }

        public TodoList atualiza(TodoList item, Integer id) {
                //item.setId(id);
                return repository.save(item);
        }

        public void deleteEmployee(@PathVariable Integer id) {
                repository.deleteById(id);
        }

}

