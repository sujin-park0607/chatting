package com.likelion.chatting.controller;

import com.likelion.chatting.domain.ChatMessage;
import com.likelion.chatting.domain.RsData;
import com.likelion.chatting.domain.dto.WriteMessageRequest;
import com.likelion.chatting.domain.dto.WriteMessageResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private List<ChatMessage> chatMessage = new ArrayList<>();

    @PostMapping("/writeMessage")
    @ResponseBody
    public RsData writeMessage(@RequestBody WriteMessageRequest request){
        ChatMessage message = new ChatMessage(request.getAuthorName(), request.getContent());
        chatMessage.add(message);
        return new RsData("S-1","메세지가 작성되었습니다.",new WriteMessageResponse(message.getId()));
    }

    @GetMapping("/messages")
    @ResponseBody
    public RsData<List<ChatMessage>> messages(){
        return new RsData("S-1","성공.",chatMessage);
    }
}
