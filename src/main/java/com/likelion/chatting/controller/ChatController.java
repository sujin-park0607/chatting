package com.likelion.chatting.controller;

import com.likelion.chatting.domain.ChatMessage;
import com.likelion.chatting.domain.RsData;
import com.likelion.chatting.domain.dto.MessagesRequest;
import com.likelion.chatting.domain.dto.MessagesResponse;
import com.likelion.chatting.domain.dto.WriteMessageRequest;
import com.likelion.chatting.domain.dto.WriteMessageResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private List<ChatMessage> chatMessage = new ArrayList<>();

    @GetMapping("/room")
    public String showRoom(){
        return "chat/room";
    }
    @PostMapping("/writeMessage")
    @ResponseBody
    public RsData writeMessage(@RequestBody WriteMessageRequest request){
        ChatMessage message = new ChatMessage(request.getAuthorName(), request.getContent());
        chatMessage.add(message);
        return new RsData("S-1","메세지가 작성되었습니다.",new WriteMessageResponse(message.getId()));
    }

    @GetMapping("/messages")
    @ResponseBody
//    public RsData<MessagesResponse> messages(@RequestParam(defaultValue = "0") Long fromId){
    public RsData<MessagesResponse> messages(MessagesRequest request){
        List<ChatMessage> messages = chatMessage;

        if( request.fromId != null){
            int index = IntStream.range(0, messages.size())
                    .filter(i -> chatMessage.get(i).getId() == request.fromId)
                    .findFirst()
                    .orElse(-1);

            if(index != -1){
                messages = messages.subList(index+1, messages.size());
            }
        }

        return new RsData("S-1","성공.",new MessagesResponse(messages, messages.size()));
    }

}
