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

    public Message saveMessage(Message message) {
        return messageRepository.saveMessage(message);
    }

    public List<Message> getMessagesByChannelId(Channel channel) {
        return messageRepository.getMessagesByChannelId(channel);
    }
}
