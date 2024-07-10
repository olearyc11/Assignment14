package com.coderscampus.Assignment14.service;

import com.coderscampus.Assignment14.domain.Channel;
import com.coderscampus.Assignment14.domain.Message;
import com.coderscampus.Assignment14.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ChannelService {

    @Autowired
    ChannelRepository channelRepository;

    private List<Channel> channels = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();

    public ChannelService() {
        channels.add(new Channel(1L, "Business", new ArrayList<>()));
        channels.add(new Channel(2L, "Cooking", new ArrayList<>()));
        channels.add(new Channel(3L, "Gaming", new ArrayList<>()));
        channels.add(new Channel(4L, "Sports", new ArrayList<>()));
        channels.add(new Channel(5L, "Tech", new ArrayList<>()));
    }

    public Map<Long, Channel> getAllChannels() {
        return channelRepository.getAllChannels();
    }

    public Channel saveChannel(Channel channel) {
        return channelRepository.saveChannel(channel);
    }

    public Channel findChannelById(Long channelId) {
        getAllChannels();
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
