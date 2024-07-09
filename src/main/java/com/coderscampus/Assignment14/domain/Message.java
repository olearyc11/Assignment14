package com.coderscampus.Assignment14.domain;

public class Message {

    private Long messageId;
    private String message;

    private User user;

    private Channel channel;

    public Message(Long messageId, String message, User user, Channel channel) {
        this.messageId = messageId;
        this.message = message;
        this.user = user;
        this.channel = channel;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + messageId +
                ", message='" + message + '\'' +
                ", user=" + user +
                ", channel=" + channel +
                '}';
    }
}
