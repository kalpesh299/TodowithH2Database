package com.example.TodoDatabase.service;

import com.example.TodoDatabase.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class Todoservices implements ITodoservice{

    private static List<Todo> todos=new ArrayList<>();//acting as a database
    private static int count=0;

    static{

        todos.add(new Todo(++count,"bhagwathgeeta",false));
        todos.add(new Todo(++count,"rach dada poor dad",false));
        todos.add(new Todo(++count,"chawa",false));
        todos.add(new Todo(++count,"chatrapati",false));
        todos.add(new Todo(++count,"chetan bhgat",false));

    }
    @Override
    public List <Todo> findAll(){
        return todos;
    }
    @Override
    public Todo findby_id(int id){
        Predicate<? super Todo> predicate= todo->todo.getId()==id;

        Todo todo=todos.stream().filter(predicate).findFirst().get();
        return todo;

    }

   // public Todo findby_name(String name){
      //  Predicate <? super Todo>predicate=todo->todo.getName()==name;

      //  Todo todo=todos.stream().filter(predicate).findFirst().get();
      //  return todo;

   // }

    @Override
    public void addtodo(Todo todo){
        todos.add(todo);
    }

    @Override
    public void delete_todo(int id){
        Predicate <? super Todo>predicate=todo->todo.getId()==id;
        todos.removeIf(predicate);
    }

    @Override
    public void update_todo(int id,Todo new_todo){
        Todo todo=findby_id(id);
        todo.setId(new_todo.getId());
        todo.setName(new_todo.getName());
        todo.setStatus(new_todo.isStatus());

    }

}
