package com.example.TodoDatabase.service;

import com.example.TodoDatabase.model.Todo;

import java.util.List;
import java.util.function.Predicate;

public interface ITodoservice {


    public List<Todo> findAll();
    public Todo findby_id(int id);

    public void addtodo(Todo todo);
    public void delete_todo(int id);
    public void update_todo(int id,Todo new_todo);
}
