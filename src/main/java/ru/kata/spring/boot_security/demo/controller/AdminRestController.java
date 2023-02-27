package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.role.RoleServiceInterface;
import ru.kata.spring.boot_security.demo.service.user.UserServiceInterface;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/")
@CrossOrigin
public class AdminRestController {

    private final UserServiceInterface userService;
    private final RoleServiceInterface roleService;


    @Autowired
    public AdminRestController(UserServiceInterface userService, RoleServiceInterface roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping
    public ResponseEntity<List<User>> showAllUsers() {
        return ResponseEntity.ok(userService.allUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<HttpStatus> newUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> editUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @GetMapping("/roles")
    public ResponseEntity<List<Role>> gerAllRoles() {
        List<Role> roles = roleService.allRoles();

        if (roles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}
