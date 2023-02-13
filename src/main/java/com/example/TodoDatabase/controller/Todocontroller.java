package com.example.TodoDatabase.controller;

import com.example.TodoDatabase.model.Todo;
import com.example.TodoDatabase.service.ITodoservice;
import com.example.TodoDatabase.service.Todoservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController ///is uses response boday by default
//@Controller //it tells spring boot to whatever request coming from browser sent it to to controller class
@RequestMapping("api/v1/todo-app")
public class Todocontroller {

    @RequestMapping("/param")
    public String hellocontroller(@RequestParam String username ){
        return "hello "+username;
    }
//// using path variable
//    @RequestMapping("/api/username/{username}")
//    public String hellocontoller(@PathVariable int username){
//        return "hello "+username;
//    }
    //-------------------------------

    @Autowired//dependancy injection other method if we use this we no need to use constructor
    private ITodoservice todoservice;

//    private final Todoservices todoservice;
//    public Todocontroller (Todoservices todoservice) {//dependency Injection
//        this.todoservice = todoservice;
//    }
    //http://localhost:8080/api/v1/todo-app/add-todo

    //http://localhost:8080/api/v1/todo-app/add-todo
    @PostMapping("/add-todo")
    public void addtodo(@RequestBody Todo todo){
        todoservice.addtodo(todo);
    }

    //http://localhost:8080/api/v1/todo-app/findby-todo/id/5
    @GetMapping("findby-todo/id/{id}")
    public Todo mappedtodobody(@PathVariable int id){
        return todoservice.findby_id(id);
    }

    //http://localhost:8080/api/v1/todo-app/findby-name/name/bhagwathgeeta
//    @GetMapping("findby-name/name/{name}")
//    public Todo mppbyname(@PathVariable String name){
//        return todoservice.findby_name(name);
//    }

    //http://localhost:8080/api/v1/todo-app/find-all
    @GetMapping("find-all")
    public List<Todo> Alltodos(){
        return todoservice.findAll();

    }
    //http://localhost:8080/api/v1/todo-app/update-todo/id/2
    @PutMapping("update-todo/id/{id}")
    public void updatetodo(@PathVariable int id,@RequestBody Todo todo){
        todoservice.update_todo(id,todo);
    }
    //http://localhost:8080/api/v1/todo-app/delete-todo/id/6
    @DeleteMapping("delete-todo/id/{id}")
    public void deletetodo(@PathVariable int id){

        todoservice.delete_todo(id);
//return new ResponseEntity<>(HttpStatus.OK);
    }


}
