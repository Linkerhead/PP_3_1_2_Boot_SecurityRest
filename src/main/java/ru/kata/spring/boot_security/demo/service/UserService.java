package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;
import java.util.Set;

public interface UserService  extends UserDetailsService {
    List<User> findAllUsers();

    void saveUser(User user);

    User createUser(User user, Set<Role> roles);

    User getOne(long id);

    User oneUserInfo();

    void updateUser(Long id, User user);

    void deleteUser(Long id);
}
