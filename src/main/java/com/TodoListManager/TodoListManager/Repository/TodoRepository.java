package com.TodoListManager.TodoListManager.Repository;

import com.TodoListManager.TodoListManager.Model.Todo;
import com.TodoListManager.TodoListManager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo ,Integer > {


    @Query(value = "Select s from Todo s Where s.id = :todoOId")
    Todo retrieveSingleTodoList(@Param("todoOId") Integer id);

    @Query(value ="select s from Todo s where s.updatedDate=(select max(s.updatedDate) from Todo s)")
    Todo getLatestUpdated();
}
