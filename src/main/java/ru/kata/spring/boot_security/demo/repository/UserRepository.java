package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username = :username")
    User findByUsername(String username);


    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.id =:id")
    User findUserById(Long id);


    @Query("Select u from User u left join fetch u.roles WHERE u.email=:email")
    Optional<User> findByEmail(String email);

}
