package com.TodoListManager.TodoListManager.Repository;

import com.TodoListManager.TodoListManager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
