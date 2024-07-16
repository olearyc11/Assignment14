package com.coderscampus.Assignment14.domain;

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

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
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
                ", message='" + messageContent + '\'' +
                ", user=" + user +
                ", channelId=" + channelId +
                '}';
    }
}
