package com.coderscampus.Assignment14.web;

import com.coderscampus.Assignment14.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChannelController {

    @Autowired
    private ChannelService channelService;




}
