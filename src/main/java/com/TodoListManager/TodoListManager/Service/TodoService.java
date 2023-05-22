package com.TodoListManager.TodoListManager.Service;

import com.TodoListManager.TodoListManager.Model.Todo;
import com.TodoListManager.TodoListManager.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
@Component
@Service
public class TodoService {


    @Autowired
TodoRepository todoRepository;

    public  void deleteTodoList(Integer id) {

        todoRepository.deleteById(id);
    }


    public void addTodoList(@org.jetbrains.annotations.NotNull Todo todo){

        Todo addListtodo = new Todo();
        addListtodo.setTitle(todo.getTitle());
        addListtodo.setDescription(todo.getDescription());
        addListtodo.setCompleted(todo.getCompleted());
        todoRepository.save(addListtodo);

    }


    public List<Todo> retrieveAllTodoList() {

        return  todoRepository.findAll();
    }

    public void updateTodo(Todo todo) {

        Todo updateTodo = new Todo();
        updateTodo.setId(todo.getId());
        updateTodo.setTitle(todo.getTitle());
        updateTodo.setDescription(todo.getDescription());
        updateTodo.setCompleted(todo.getCompleted());
        todoRepository.save(updateTodo);


    }


    public Todo retrieveSingleTodoList(Integer id) {

        Todo todo = todoRepository.retrieveSingleTodoList(id);
        return  todo;
    }


//    public Todo getLatestUpdated() {
//
//
//        return todoRepository.getLatestUpdated();
//    }

}
