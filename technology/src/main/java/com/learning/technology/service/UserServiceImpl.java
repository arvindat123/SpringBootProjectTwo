package com.learning.technology.service;

import com.learning.technology.model.User;
import com.learning.technology.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {

        List<User> users = userRepository.findAll();
        logger.info("@@Getting data from DB"+users);
        return users;
    }

    @Override
    public List<User> getUserByAddress(String address) {
        return userRepository.findByAddress(address);
    }

    @Override
    public void deleteUser(User user) {

        userRepository.delete(user);
    }
}
