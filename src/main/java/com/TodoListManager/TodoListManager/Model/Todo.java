package com.TodoListManager.TodoListManager.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "todos")
public class Todo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

     String title;
    String description;

    Boolean completed;

    @ManyToOne
    @JoinColumn(name = "User_id",referencedColumnName = "id")
    User user;


}
