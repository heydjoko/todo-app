package com.example.todoapp.service;

import com.example.todoapp.entity.ToDo;
import com.example.todoapp.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository todoRepository;

    public ToDo saveToDo(ToDo todo) {
            System.out.println(todo.toString());
            return todoRepository.save(todo);
    }
    public List<ToDo> saveToDos(List<ToDo> todos) {
            return todoRepository.saveAll(todos);
    }

    public List<ToDo> getToDos() {
        return todoRepository.findAll();
    }
    public ToDo getToDoById(int id) {
        return todoRepository.findById(id).orElse(null);
    }
    public ToDo getToDoByName(String name) {
        return todoRepository.findByName(name);
    }
    public List<ToDo> getToDosForUser(String username) {
            return todoRepository.findAllByUsername(username);
    }

    public ToDo updateToDo(ToDo todo) {
        System.out.println("updates");
        ToDo existing_todo = todoRepository.findById(todo.getId()).orElse(null);
        existing_todo.setName(todo.getName());
        existing_todo.setContent(todo.getContent());
        existing_todo.setStatus(todo.getStatus());
        return todoRepository.save(existing_todo);
    }

    public String deleteToDo(int id) {
        todoRepository.deleteById(id);
        return id + " id -> todo removed/completed";
    }
}