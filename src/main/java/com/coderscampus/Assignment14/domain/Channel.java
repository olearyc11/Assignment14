package com.coderscampus.Assignment14.domain;

import java.util.List;

public class Channel {

    private Long channelId;
    private String name;
    private List<Message> messages;

    public Channel(Long channelId, String name, List<Message> messages) {
        this.channelId = channelId;
        this.name = name;
        this.messages = messages;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + channelId +
                ", name='" + name + '\'' +
                ", messages=" + messages +
                '}';
    }


}
