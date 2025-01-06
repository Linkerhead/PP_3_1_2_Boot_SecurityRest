package ru.kata.spring.boot_security.demo.dbInitiatiation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.util.Optional;

@Component
public class DataInitializer implements CommandLineRunner {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    PasswordEncoder passwordEncoder;

    @Autowired
    public DataInitializer(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        Role adminRole = createRoleI("ROLE_ADMIN");
        Role userRole = createRoleI("ROLE_USER");

        createUser("admin", "admin", adminRole);
        createUser("user", "user", userRole);
    }


    private void createUser(String username, String password, Role role) {
        if (!userRepository.existsByUsername(username)) {
            System.out.println("User: " + username + "was created");
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.getRoles().add(role);
            userRepository.save(user);
        }
    }

    private Role createRoleI(String roleName) {
        Optional<Role> existingRole = roleRepository.findByName(roleName);
        if (existingRole.isPresent()) {
            return existingRole.get();
        } else {
            Role newRole = new Role();
            newRole.setName(roleName);
            return roleRepository.save(newRole);
        }
    }


}