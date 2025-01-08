package ru.kata.spring.boot_security.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kata.spring.boot_security.demo.entities.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getAllRoles();
    void saveRole(Role role);
}
