package com.likelion.chatting.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class WriteMessageRequest {
    private String authorName;
    private String content;
}
