package com.coderscampus.Assignment14.web;

import com.coderscampus.Assignment14.domain.Channel;
import com.coderscampus.Assignment14.domain.User;
import com.coderscampus.Assignment14.service.ChannelService;
import com.coderscampus.Assignment14.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WelcomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private ChannelService channelService;


    @PostMapping("/welcome")
    public String saveUser(@RequestBody User user) {
        userService.save(user);
        System.out.println("User saved");
        System.out.println(user);
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String welcome(ModelMap model) {
        List<Channel> channels = channelService.getAllChannels();
        model.put("channels", channels);
        return "welcome";
    }



}
