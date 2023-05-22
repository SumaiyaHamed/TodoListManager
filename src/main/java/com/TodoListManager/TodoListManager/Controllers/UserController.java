package com.TodoListManager.TodoListManager.Controllers;

import com.TodoListManager.TodoListManager.Model.User;
import com.TodoListManager.TodoListManager.Repository.UserRepository;
import com.TodoListManager.TodoListManager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserService userService;

    //    User Registration:
//    Endpoint: POST /api/register
//    Request Payload: { "username": "john", "password": "password123" }

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
            return "User added Successfully";
        } catch (Exception e) {
            return "User added Failed";
        }  }


/*        @GetMapping(value = "test")
        public String addUser() {
            try {
                return "User added Successfully";
            } catch (Exception e) {
                return "User added Failed";
            }

        }*/
}
