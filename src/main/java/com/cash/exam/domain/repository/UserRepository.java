package com.cash.exam.domain.repository;

import com.cash.exam.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAllUsers();
    Optional<User> getUserById (int id);
    User addUser(User user);
    void deleteUser (int id);
}
