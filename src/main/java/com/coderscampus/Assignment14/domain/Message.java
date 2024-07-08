package com.coderscampus.Assignment14.domain;

public class Message {

    private Long id;
    private String message;

    private User user;

    private Channel channel;

    public Message(Long id, String message, User user, Channel channel) {
        this.id = id;
        this.message = message;
        this.user = user;
        this.channel = channel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", message='" + message + '\'' +
                ", user=" + user +
                ", channel=" + channel +
                '}';
    }
}
