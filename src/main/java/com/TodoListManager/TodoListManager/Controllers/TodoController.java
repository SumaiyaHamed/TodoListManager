package com.TodoListManager.TodoListManager.Controllers;

import com.TodoListManager.TodoListManager.Model.Todo;
import com.TodoListManager.TodoListManager.Model.User;
import com.TodoListManager.TodoListManager.Repository.TodoRepository;
import com.TodoListManager.TodoListManager.Service.TodoService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(value = "todo")
@RestController
public class TodoController {
@Autowired
    TodoService todoService;
    @RequestMapping(value = "addList", method = RequestMethod.POST)
    public String addList(@RequestBody Todo todo) {
        try {
            todoService.addTodoList(todo);
            return "List added Successfully";
        } catch (Exception e) {
            return "List added Failed";
        }  }


    @RequestMapping(value = "retrieveAllTodoList", method = RequestMethod.GET)
    public List<Todo> retrieveAllTodoList(@RequestParam Integer userid){

        return todoService.retrieveAllTodoList();
    }


    @RequestMapping(value = "deleteTodoList", method = RequestMethod.POST)
    public String deleteTodoList(Integer id) {
        try {
            todoService.deleteTodoList(id);
            return "TodoList deleted Successfully";

        } catch (Exception e) {
            return "TodoList delete failed";
        }
    }

    @RequestMapping(value = "updateTodo", method = RequestMethod.POST)
    public String updateTodo(@RequestBody Todo todo) {
        try {
            todoService.updateTodo(todo);
            return "List Update Successfully";
        } catch (Exception e) {
            return "List Update Failed";
        }  }


//    @RequestMapping(value = "retrieveSingleTodoList", method = RequestMethod.GET)
//    public List<Todo> retrieveSingleTodoList(@RequestParam Integer userid){
//
//        return todoService.retrieveSingleTodoList();
//    }


    @RequestMapping(value = "retrieveSingleTodoList", method = RequestMethod.GET)
    public Todo retrieveSingleTodoList(@RequestParam Integer id){
        Todo todo = todoService.retrieveSingleTodoList(id);
        return todo;
    }


}
