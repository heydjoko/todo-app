package com.example.todoapp.repositories;

import com.example.todoapp.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
    ToDo findByName(String name);

    List<ToDo> findAllByUsername(String username);
}
