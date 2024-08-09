package com.coderscampus.Assignment14.web;

import com.coderscampus.Assignment14.domain.Channel;
import com.coderscampus.Assignment14.domain.User;
import com.coderscampus.Assignment14.service.ChannelService;
import com.coderscampus.Assignment14.service.UserService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class WelcomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private ChannelService channelService;

    @GetMapping("/welcome")
    public String welcome(ModelMap model) {
        List<Channel> channels = channelService.getAllChannels();
        model.put("channels", channels);
        return "welcome";
    }

    @PostMapping("/welcome")
    @ResponseBody
    public User saveUser(@RequestBody Map<String, String> payload, HttpSession session) {
        String username = payload.get("username");
        String sessionId = payload.get("sessionId");
        System.out.println("SessionId: " + sessionId);

        User user = new User(null, username);
        userService.save(user);
        System.out.println("User saved: " + user);

        session.setAttribute("sessionId", sessionId);
        session.setAttribute("username_" + sessionId, user.getUsername());
        session.setAttribute("userId_" + sessionId, user.getUserId());

        return user;
    }
}
