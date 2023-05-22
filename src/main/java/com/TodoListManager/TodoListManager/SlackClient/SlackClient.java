package com.TodoListManager.TodoListManager.SlackClient;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SlackClient {


    public String sendMessage(String text){

        return WebClient.create().post()
                .uri("https://hooks.slack.com/services/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")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new SlackPayload(text))
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }
}
