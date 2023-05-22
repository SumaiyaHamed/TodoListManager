package com.TodoListManager.TodoListManager.CRONJob;

import com.TodoListManager.TodoListManager.Model.Todo;
import com.TodoListManager.TodoListManager.Service.TodoService;
import com.TodoListManager.TodoListManager.SlackClient.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@RequestMapping(value = "CRONJobWeatherDay")
public class CRONJobWeatherDay {

@Autowired
    TodoService todoService;
    @Autowired
    SlackClient slackClient;
    @Scheduled(cron = "0 */11 * * * *")
    public Todo getLatestUpdated() {
        Todo todo= todoService.getLatestUpdated();

        slackClient.sendMessage("+++ TodoList/getLatestUpdated +++");

        slackClient.sendMessage("Todo Id is:" + todo.getId() + "\t Todo Title is :" + todo.getTitle() +
                "\t Todo Description is  :" + todo.getDescription()+ "\t Todo Completed  :" + todo.getCompleted());
        return todo;

    }


}
