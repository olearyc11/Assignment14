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
import java.util.Map;

@Controller
public class ChannelController {

    @Autowired
    private ChannelService channelService;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    @GetMapping("/channels/{channelId}")
    public String getChannel(@PathVariable Long channelId, ModelMap model) {
        Channel channel = channelService.findChannelById(channelId);
        model.put("channel", channel);
        return "channel";
    }

    @PostMapping("/channels/{channelId}/messages")
    @ResponseBody
    public Message postMessage(@PathVariable Long channelId, @RequestBody Map<String, String> payload) {
        String username = payload.get("username");
        String messageContent = payload.get("messageContent");
        User user = userService.findUserByUsername(username);
        Channel channel = channelService.findChannelById(channelId);
        Message message = new Message(null, messageContent, user, channelId);
        return messageService.saveMessage(message);
    }

    @GetMapping("/channels/{channelId}/messages")
    @ResponseBody
    public List<Message> getMessagesForChannel(@PathVariable Long channelId) {
        Channel channel = channelService.findChannelById(channelId);
        return messageService.getMessagesByChannelId(channelId);
    }

}
