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


    @PostMapping("/welcome")
    public String saveUser(@RequestBody User user, HttpSession session) {
        userService.save(user);
        System.out.println("User saved: " + user);
        session.setAttribute("username", user.getUsername());
        session.setAttribute("userId", user.getUserId());
        System.out.println("Session username: " + session.getAttribute("username"));
        System.out.println("Session userID: " + session.getAttribute("userId"));
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String welcome(ModelMap model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            User user = userService.findUserById(userId);
            model.put("user", user);
        }
        Map<Long, Channel> channels = channelService.getAllChannels();
        model.put("channels", channels);
        return "welcome";
    }



}
