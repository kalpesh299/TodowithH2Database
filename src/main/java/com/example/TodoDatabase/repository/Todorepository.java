package com.example.TodoDatabase.repository;

import com.example.TodoDatabase.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Todorepository extends JpaRepository<Todo,Integer> {///model ans data type of primary key here primary key is id so e ar using integer
}
