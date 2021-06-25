package com.cash.exam.domain.service;

import com.cash.exam.domain.User;
import com.cash.exam.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers () {
        return userRepository.getAllUsers();
    }

    public Optional<User> getUserById (int id) {
        return userRepository.getUserById(id);
    }

    public boolean deleteUser (int id) {
       return getUserById(id).map(user -> {
           userRepository.deleteUser(id);
           return true;
       }).orElse(false);
    }

    public User addUser (User user){
        return userRepository.addUser(user);
    }
}
