package com.example.todoapp.controller;

import com.example.todoapp.entity.ToDo;
import com.example.todoapp.service.ToDoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class ToDoController {
    @Autowired
    private ToDoService todoService;

    @PostMapping("/addToDo")
    public ToDo addToDo(@RequestBody ToDo todo) {
        return todoService.saveToDo(todo);
    }

    @PostMapping("/addToDos")
    public List<ToDo> addToDos(@RequestBody List<ToDo> todos) {
        return todoService.saveToDos(todos);
    }

    @GetMapping("/todos")
    public List<ToDo> getAllToDos() {
        return todoService.getToDos();
    }

    @GetMapping("/todoById/{id}")
    public ToDo findToDoById(@PathVariable int id) {
        return todoService.getToDoById(id);
    }

    @GetMapping("/todoByName/{name}")
    public ToDo findToDoByName(@PathVariable String name) {
        return todoService.getToDoByName(name);
    }

    @GetMapping("/todoListByUsername/{username}")
    public List<ToDo> findToDoByUsername(@PathVariable String username) {
        return todoService.getToDosForUser(username);
    }

    @PutMapping("/update")
    public ToDo updateToDo(@RequestBody ToDo todo)
    {
        System.out.println("UPDATED");
        return todoService.updateToDo(todo);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteToDo(@PathVariable int id) {
        return todoService.deleteToDo(id);
    }
}