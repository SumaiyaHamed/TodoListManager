package com.TodoListManager.TodoListManager.Service;

import com.TodoListManager.TodoListManager.Model.User;
import com.TodoListManager.TodoListManager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addUser(@org.jetbrains.annotations.NotNull User user){

        User addUser1 = new User();
        addUser1.setUsername(user.getUsername());
        addUser1.setPassword(user.getPassword());
        userRepository.save(addUser1);

    }


}
