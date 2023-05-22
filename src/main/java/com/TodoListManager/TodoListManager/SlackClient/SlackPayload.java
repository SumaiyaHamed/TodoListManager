package com.TodoListManager.TodoListManager.SlackClient;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SlackPayload {

    private String text;

    public SlackPayload(String text){
        this.text = text;
    }
}
