package com.ricou.api.todolist.controller;

import com.ricou.api.todolist.Model.TodoEntity;
import com.ricou.api.todolist.Service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/todo")
public class TodoController {

    // Lombok va génèrer un constructeur avec un paramètre pour chaque constante (final)
    private final TodoService todoService;

    @GetMapping("/")
    public Iterable<TodoEntity> getTodos() {
        // Retourne la liste des taches à réaliser
        return todoService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<TodoEntity> getTodoById(@PathVariable("id") Long id) {
        // Retourne une taches à réaliser par son identifiant
        return todoService.getById(id);
    }

    @PostMapping("/")
    public TodoEntity addTodo(@RequestBody TodoEntity todolistEntity) {
        return todoService.add(todolistEntity);
    }

    @PutMapping("/{id}")
    public void editTodo(@RequestBody TodoEntity todolistEntity) {
        todoService.edit(todolistEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        todoService.delete(id);
    }
}
