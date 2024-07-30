package com.coderscampus.Assignment14.domain;
import lombok.Data;

@Data
public class Message {

    private Long messageId;
    private String messageContent;

    private User user;

    private Long channelId;



    public Message(Long messageId, String messageContent, User user, Long channelId) {
        this.messageId = messageId;
        this.messageContent = messageContent;
        this.user = user;
        this.channelId = channelId;
    }
}
