package com.coderscampus.Assignment14.repository;

import com.coderscampus.Assignment14.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public void saveUser(User user) {
        users.add(user);
    }

    public List<User> findAll() {
        return users;
    }

    public void save(User user) {
        users.add(user);
    }


}
