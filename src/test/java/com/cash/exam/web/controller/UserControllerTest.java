package com.cash.exam.web.controller;

import com.cash.exam.domain.User;
import com.cash.exam.domain.repository.UserRepository;
import com.cash.exam.domain.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    UserRepository userRepository = Mockito.mock(UserRepository.class);

    @Autowired
    UserController userController = new UserController();

    @BeforeEach
    void setUp() {
        User usuario = new User();
        usuario.setEmail("test@app.com.ar");
        usuario.setId(1);
        usuario.setLastName("Argento");
        usuario.setFirstName("Pepe");

        Mockito.when(userRepository.getUserById(1)).thenReturn(java.util.Optional.of(usuario));
    }

    @Test
    void getUserById() {
        ResponseEntity<User> us;
        us = userController.getUserById(1);

        Assertions.assertEquals("test@app.com.ar",us.getBody().getEmail());
        Assertions.assertEquals("Argento",us.getBody().getLastName());
        Assertions.assertEquals("Pepe",us.getBody().getFirstName());
    }

}