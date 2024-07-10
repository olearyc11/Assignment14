package com.coderscampus.Assignment14.service;

import com.coderscampus.Assignment14.domain.Channel;
import com.coderscampus.Assignment14.domain.Message;
import com.coderscampus.Assignment14.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    private List<Message> messages = new ArrayList<>();


    public List<Message> getMessagesByChannelId(Channel channel) {
        List<Message> channelMessages = new ArrayList<>();
        for (Message message : messages) {
            if (message.getChannelId().equals(channel.getChannelId())) {
                channelMessages.add(message);
            }
        }
        return channelMessages;
    }

    public List<Message> saveMessage(Message message) {
        Long messageId = (long) (messages.size() + 1);
        message.setMessageId(messageId);
        messages.add(message);
        return messages;
    } // maybe just return message?

}
