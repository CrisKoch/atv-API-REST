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


import com.kochmann.domain.TodoListItem;
import com.kochmann.service.TodoListItemService;


@RestController
@RequestMapping("/todolistitem")
class TodoListItemController {

        @Autowired
        private TodoListItemService service;

        @GetMapping
        public List<TodoListItem> all() {
                return service.todos();
        }
        
        @PostMapping
        public TodoListItem novo(@RequestBody TodoListItem pessoa) {
                return service.novo(pessoa);
        }

        @GetMapping("/{id}")
        public TodoListItem one(@PathVariable Integer id) {
                return service.pessoa(id);
        }

        @PutMapping("/{id}")
        public TodoListItem replaceEmployee(@RequestBody TodoListItem pessoa, @PathVariable Integer id) {
                return service.atualiza(pessoa, id);
        }

        @DeleteMapping("/{id}")
        void deleteEmployee(@PathVariable Integer id) {
                service.deleteEmployee(id);
        }
}
