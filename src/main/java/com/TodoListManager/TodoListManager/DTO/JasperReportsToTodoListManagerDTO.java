package com.TodoListManager.TodoListManager.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class JasperReportsToTodoListManagerDTO {

    Integer todoListId ;
    String todoListTitle;
    String todoListDescription ;

    Boolean Completed;

    public JasperReportsToTodoListManagerDTO(Integer todoListId, String todoListTitle, String todoListDescription, Boolean Completed) {
        this.todoListId = todoListId;
        this.todoListTitle = todoListTitle;
        this.todoListDescription = todoListDescription;
        this.Completed = Completed;
    }
}
