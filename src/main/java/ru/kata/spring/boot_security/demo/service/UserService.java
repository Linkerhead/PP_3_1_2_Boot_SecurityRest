package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;


public interface UserService  extends UserDetailsService {
    List<User> findAllUsers();

    void saveUser(User user);

    User createUser(User user, List<Role> roles);


    User oneUserInfo();

    void updateUser(Long id, User user, String password, List<Role> roles);

    void deleteUser(Long id);

    User findByUsername(String username);
}
