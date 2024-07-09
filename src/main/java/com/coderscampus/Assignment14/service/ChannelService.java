package com.coderscampus.Assignment14.service;

import com.coderscampus.Assignment14.domain.Channel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelService {

    private List<Channel> channels = new ArrayList<>();

    public ChannelService() {
        channels.add(new Channel(1L, "Business", new ArrayList<>()));
        channels.add(new Channel(2L, "Cooking", new ArrayList<>()));
        channels.add(new Channel(3L, "Gaming", new ArrayList<>()));
        channels.add(new Channel(4L, "Sports", new ArrayList<>()));
        channels.add(new Channel(5L, "Tech", new ArrayList<>()));
    }

    public List<Channel> getAllChannels() {
        return channels;
    }

    public void addChannel(Channel channel) {
        channels.add(channel);
    }

}
