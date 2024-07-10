package com.coderscampus.Assignment14.web;

import com.coderscampus.Assignment14.domain.Channel;
import com.coderscampus.Assignment14.domain.Message;
import com.coderscampus.Assignment14.domain.User;
import com.coderscampus.Assignment14.service.ChannelService;
import com.coderscampus.Assignment14.service.MessageService;
import com.coderscampus.Assignment14.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChannelController {

    @Autowired
    private ChannelService channelService;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    @GetMapping("/channels/{channelId}")
    public String getChannel(@PathVariable Long channelId, HttpSession session, ModelMap model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/welcome";
        }
        User user = userService.findUserById(userId);
        Channel channel = channelService.findChannelById(channelId);
        model.put("channel", channel);
        model.put("user", user);
        return "channel";
    }

    @GetMapping("/channels/{channelId}/messages")
    @ResponseBody
    public List<Message> getChannelMessages(@PathVariable Long channelId) {
        Channel channel = channelService.findChannelById(channelId);
        return messageService.getMessagesByChannelId(channel);
    }


}
