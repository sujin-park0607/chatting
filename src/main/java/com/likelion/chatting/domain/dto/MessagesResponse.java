package com.likelion.chatting.domain.dto;

import com.likelion.chatting.domain.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class MessagesResponse {
    private List<ChatMessage> messages;
    private long count;
}
