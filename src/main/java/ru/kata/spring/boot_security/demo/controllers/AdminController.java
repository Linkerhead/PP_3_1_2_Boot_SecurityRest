package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;


import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;


    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public List<User> admin() {
        return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        return userService.findUserById(id);
    }

    @GetMapping("users/roles")
    public List<Role> allRoles() {
        return roleService.getAllRoles();
    }

    @PostMapping(value = "/new")
    public ResponseEntity<HttpStatus> newUser(@RequestBody User user) {
        userService.saveUser(userService.createUser(user, user.getRoles()));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<HttpStatus> update(@RequestBody User user) {
        userService.updateUser(user.getId(), user, user.getPassword(), user.getRoles());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/authUser")
    public ResponseEntity<User> authenticationUser() {
        User user = userService.oneUserInfo();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}








