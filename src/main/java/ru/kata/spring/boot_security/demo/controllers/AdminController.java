package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;

import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;


    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getUsers(Model model, Principal principal) {
        User currentUser = userService.findByUsername(principal.getName());
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("users", userService.findAllUsers());
        return "users";
    }

    @GetMapping(value = "/new")
    public String newUser(Model model, Principal principal) {
        User currentUser = userService.findByUsername(principal.getName());
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("user", new User());
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        return "newUser";
    }


    @PostMapping("/new")
    public String createUser(@ModelAttribute User user, @RequestParam(value = "role") List<Role> roles) {
        userService.saveUser(userService.createUser(user, roles));
        return "redirect:/admin/";
    }

    @GetMapping("/user")
    public String userInfo(Model model, Principal principal) {
        User currentUser = userService.findByUsername(principal.getName());
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("userAdmin", userService.oneUserInfo());
        return "userAdmin";
    }


    @PostMapping(value = "/update")
    public String update(@ModelAttribute("user") User user,
                         @RequestParam("id") long id,
                         @RequestParam(value = "role", required = false) List<Role> roles) {

        String password = user.getPassword();
        userService.updateUser(id, user, password, roles);
        return "redirect:/admin";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
