package com.TodoListManager.TodoListManager.Controllers;

import com.TodoListManager.TodoListManager.Model.Todo;
import com.TodoListManager.TodoListManager.Model.User;
import com.TodoListManager.TodoListManager.Repository.TodoRepository;
import com.TodoListManager.TodoListManager.Service.TodoService;
import com.TodoListManager.TodoListManager.SlackClient.SlackClient;
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

    @Autowired
    SlackClient slackClient;

//_______________________________________________________________________________________________
//    Todo Creation:
//    Endpoint: POST /api/todos
//    Request Payload: { "title": "Buy groceries", "description": "Milk, eggs, bread" }

    @RequestMapping(value = "addList", method = RequestMethod.POST)
    public String addList(@RequestBody Todo todo) {
        try {
            todoService.addTodoList(todo);
            return "List added Successfully";
        } catch (Exception e) {
            return "List added Failed";
        }  }

    //_______________________________________________________________________________________________
//    Todo Retrieval (All todos):
//    Endpoint: GET /api/todos
//Response Payload: [{ "id": 1, "title": "Buy groceries", "description": "Milk, eggs, bread", "completed": false }]

    @RequestMapping(value = "retrieveAllTodoList", method = RequestMethod.GET)
    public List<Todo> retrieveAllTodoList(@RequestParam Integer userid){

        return todoService.retrieveAllTodoList();
    }
//_______________________________________________________________________________________________
//    Todo Deletion:
//    Endpoint: DELETE /api/todos/{todoId}
//    Response: 204 No Content

    @RequestMapping(value = "deleteTodoList", method = RequestMethod.POST)
    public String deleteTodoList(Integer id) {
        try {
            todoService.deleteTodoList(id);
            return "TodoList deleted Successfully";

        } catch (Exception e) {
            return "TodoList delete failed";
        }
    }
//_______________________________________________________________________________________________

//    Todo Update:
//    Endpoint: PUT /api/todos/{todoId}
//    Request Payload: { "completed": true }
//    Response: 200 OK

    @RequestMapping(value = "updateTodo", method = RequestMethod.POST)
    public String updateTodo(@RequestBody Todo todo) {
        try {
            todoService.updateTodo(todo);
            return "List Update Successfully";
        } catch (Exception e) {
            return "List Update Failed";
        }  }

//_______________________________________________________________________________________________


//    Todo Retrieval (Single todo):
//    Endpoint: GET /api/todos/{todoId}
//    Response: 200 OK
//    Response Payload: { "id": 1, "title": "Buy groceries", "description": "Milk, eggs, bread", "completed": false }
    @RequestMapping(value = "retrieveSingleTodoList", method = RequestMethod.GET)
    public Todo retrieveSingleTodoList(@RequestParam Integer id){
        Todo todo = todoService.retrieveSingleTodoList(id);
        return todo;
    }


    //_______________________________________________________________________________________________
//    CRON Job:
//    Endpoint: POST /api/cron/updateWeatherData
//    Response: 200 OK

    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)

    public Todo getLatestUpdated() {
        Todo todo = todoService.getLatestUpdated();

        slackClient.sendMessage("+++ TodoList/getLatestUpdated +++");


        slackClient.sendMessage("Todo Id is:" + todo.getId() + "\t Todo Title is :" + todo.getTitle() +
                "\t Todo Description is  :" + todo.getDescription()+ "\t Todo Completed  :" + todo.getCompleted());
        return todo;

    }

}
