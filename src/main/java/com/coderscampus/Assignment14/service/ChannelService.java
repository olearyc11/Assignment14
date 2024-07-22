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

    public List<Channel> getAllChannels() {
        return channelRepository.getAllChannels();
    }

    public Channel saveChannel(Channel channel) {
        return channelRepository.saveChannel(channel);
    }

    public Channel findChannelById(Long channelId) {
        return channelRepository.findChannelById(channelId);
    }
}
