package com.coderscampus.Assignment14.repository;

import com.coderscampus.Assignment14.domain.Channel;
import com.coderscampus.Assignment14.domain.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {

    private List<Message> messages = new ArrayList<>();

    public Message saveMessage(Message message) {
        Long messageId = (long) (messages.size() + 1);
        message.setMessageId(messageId);
        messages.add(message);
        System.out.println(message.toString());
        return message;
    }

    public List<Message> getMessagesByChannelId(Long channelId) {
        List<Message> channelMessages = new ArrayList<>();
        for (Message message : messages) {
            if (message.getChannelId().equals(channelId)) {
                channelMessages.add(message);
            }
        }
        return channelMessages;
    }

}
