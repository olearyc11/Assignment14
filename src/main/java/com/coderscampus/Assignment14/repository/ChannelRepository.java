package com.coderscampus.Assignment14.repository;

import com.coderscampus.Assignment14.domain.Channel;
import com.coderscampus.Assignment14.domain.Message;
import com.coderscampus.Assignment14.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ChannelRepository {

    private List<Channel> channels = new ArrayList<>();
    private AtomicLong channelIdGenerator = new AtomicLong();
    private List<Message> messages = new ArrayList<>();

    public ChannelRepository() {
        channels.add(new Channel(1L, "Business", new ArrayList<>()));
        channels.add(new Channel(2L, "Cooking", new ArrayList<>()));
        channels.add(new Channel(3L, "Gaming", new ArrayList<>()));
        channels.add(new Channel(4L, "Sports", new ArrayList<>()));
        channels.add(new Channel(5L, "Tech", new ArrayList<>()));
    }


    public List<Channel> getAllChannels() {
        return channels;
    }
    public Channel saveChannel(Channel channel) {
        if (channel.getChannelId() == null) {
            Long newChannelId = channelIdGenerator.incrementAndGet();
            channel.setChannelId(newChannelId);
        }
        channels.add(channel);
        return channel;
    }

    public Channel findChannelById(Long channelId) {
        for (Channel channel : channels) {
            if (channel.getChannelId().equals(channelId)) {
                return channel;
            }
        }
        return null;
    }

    public List<Message> getMessagesByChannelId(Channel channel) {
        List<Message> channelMessages = new ArrayList<>();
        for (Message message : messages) {
            if (message.getChannelId().equals(channel.getChannelId())) {
                channelMessages.add(message);
            }
        }
        return channelMessages;
    }

}
