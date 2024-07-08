package com.coderscampus.Assignment14.service;

import com.coderscampus.Assignment14.domain.User;
import com.coderscampus.Assignment14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private AtomicLong idCounter = new AtomicLong();

    public void save(User user) {
        if (user.getId() == null) {
            user.setId(idCounter.incrementAndGet());
        }
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
