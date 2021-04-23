package com.kochmann.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import com.kochmann.domain.TodoListItem;
import com.kochmann.repository.TodoListItemRepository;


@Service
public class TodoListItemService {

        @Autowired
        TodoListItemRepository repository;

        public List<TodoListItem> todos() {
                return repository.findAll();
        }

        public TodoListItem novo(TodoListItem item) {
                return repository.save(item);
        }

        public TodoListItem pessoa(Integer id) {
                return repository.findById(id).orElseThrow(() -> new TodoListItemNaoEncontradoException(id));
        }

        public TodoListItem atualiza(TodoListItem item, Integer id) {
                //item.setId(id);
                return repository.save(item);
        }

        public void deleteEmployee(@PathVariable Integer id) {
                repository.deleteById(id);
        }

}

