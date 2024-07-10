package com.coderscampus.Assignment14.repository;

import com.coderscampus.Assignment14.domain.Channel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ChannelRepository {

    private Map<Long, Channel> channels = new HashMap<>();
    private AtomicLong channelIdGenerator = new AtomicLong();

    public Map<Long, Channel> getAllChannels() {
        return channels;
    }
    public Channel saveChannel(Channel channel) {
        if (channel.getChannelId() == null) {
            Long newChannelId = channelIdGenerator.incrementAndGet();
            channel.setChannelId(newChannelId);
        }
        channels.put(channel.getChannelId(), channel);
        return channel;
    }

}
