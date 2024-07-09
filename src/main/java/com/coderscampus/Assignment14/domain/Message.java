package com.coderscampus.Assignment14.domain;

public class Message {

    private Long messageId;
    private String message;

    private User user;

    private Long channelId;



    public Message(Long messageId, String message, User user, Long channelId) {
        this.messageId = messageId;
        this.message = message;
        this.user = user;
        this.channelId = channelId;
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

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }


    @Override
    public String toString() {
        return "Message{" +
                "id=" + messageId +
                ", message='" + message + '\'' +
                ", user=" + user +
                ", channelId=" + channelId +
                '}';
    }
}
