package com.coderscampus.Assignment14.repository;

import com.coderscampus.Assignment14.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();
    private AtomicLong userIdGenerator = new AtomicLong();

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getUserId() == null) {
            user.setUserId(userIdGenerator.incrementAndGet());
        }
        users.add(user);
        return user;
    }

    public User findByUserId(Long userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }


}
