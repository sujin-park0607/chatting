package com.likelion.chatting.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ChatMessage {
    private long id;
    private LocalDateTime createDate;
    private String authorName;
    private String content;

    public ChatMessage(String authorName, String content){
        this(ChatMessageIdGenerator.getNextId(), LocalDateTime.now(), authorName, content);
    }

}

class ChatMessageIdGenerator{
    private static long id = 1;

    public static long getNextId() {
        return id++;
    }
}