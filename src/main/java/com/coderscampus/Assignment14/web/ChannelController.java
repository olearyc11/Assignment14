package com.coderscampus.Assignment14.web;

import com.coderscampus.Assignment14.domain.Channel;
import com.coderscampus.Assignment14.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @GetMapping("/channels/{channelId}")
    public String getChannel(@PathVariable Long channelId, ModelMap model) {
        Channel channel = channelService.findChannelById(channelId);
        model.put("channel", channel);
        return "channel";
    }



}
