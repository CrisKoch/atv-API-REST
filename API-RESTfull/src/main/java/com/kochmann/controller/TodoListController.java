package com.kochmann.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.kochmann.domain.TodoList;
import com.kochmann.service.TodoListService;

@RestController
@RequestMapping("/todolist")
class TodoListController {

        @Autowired
        private TodoListService service;

        @GetMapping
        public List<TodoList> all() {
                return service.todos();
        }
        
        @PostMapping
        public TodoList novo(@RequestBody TodoList pessoa) {
                return service.novo(pessoa);
        }

        @GetMapping("/{id}")
        public TodoList one(@PathVariable Integer id) {
                return service.pessoa(id);
        }

        @PutMapping("/{id}")
        public TodoList replaceEmployee(@RequestBody TodoList pessoa, @PathVariable Integer id) {
                return service.atualiza(pessoa, id);
        }

        @DeleteMapping("/{id}")
        void deleteEmployee(@PathVariable Integer id) {
                service.deleteEmployee(id);
        }
}
