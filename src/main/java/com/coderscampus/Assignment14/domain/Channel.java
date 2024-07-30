package com.coderscampus.Assignment14.domain;
import lombok.Data;
import java.util.List;

@Data
public class Channel {

    private Long channelId;
    private String name;
    private List<Message> messages;

    public Channel(Long channelId, String name, List<Message> messages) {
        this.channelId = channelId;
        this.name = name;
        this.messages = messages;
    }
}
