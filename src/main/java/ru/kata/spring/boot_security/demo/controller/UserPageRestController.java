package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.user.UserServiceInterface;

import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserPageRestController {
      private final UserServiceInterface userService;

    public UserPageRestController(UserServiceInterface userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<User> getUser(Principal principal) {
        return new ResponseEntity<>(userService.findByUserName(principal.getName()).orElse(null), HttpStatus.OK);
    }
}
