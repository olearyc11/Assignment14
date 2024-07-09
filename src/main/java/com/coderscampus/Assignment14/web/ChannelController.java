package com.coderscampus.Assignment14.web;

import com.coderscampus.Assignment14.domain.Channel;
import com.coderscampus.Assignment14.domain.User;
import com.coderscampus.Assignment14.service.ChannelService;
import com.coderscampus.Assignment14.service.MessageService;
import com.coderscampus.Assignment14.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChannelController {

    @Autowired
    private ChannelService channelService;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    @GetMapping("/channels/{channelId}")
    public String getChannel(@PathVariable Long channelId, @RequestParam(required = false) String username, HttpSession httpSession) {
        Long userId = (Long) httpSession.getAttribute("user_id");
            if (userId == null) {
            return "redirect:/login";
        }
        Channel channel = channelService.findChannelById(channelId);
        return "channel";
    }



}
