package com.coderscampus.Assignment14.service;

import com.coderscampus.Assignment14.domain.Channel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelService {

    private List<Channel> channels = new ArrayList<>();

    public List<Channel> getAllChannels() {
        return channels;
    }

    public void addChannel(Channel channel) {
        channels.add(channel);
    }

}
