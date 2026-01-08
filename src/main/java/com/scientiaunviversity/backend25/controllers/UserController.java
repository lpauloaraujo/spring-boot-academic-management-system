package com.scientiaunviversity.backend25.controllers;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.scientiaunviversity.backend25.domain.Professor;
import com.scientiaunviversity.backend25.domain.Student;
import com.scientiaunviversity.backend25.domain.User;
import com.scientiaunviversity.backend25.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/students")
    public Student create(@RequestBody Student student) {
        return userService.create(student);
    }

    @PostMapping("/professors")
    public Professor create(@RequestBody Professor professor) {return userService.create(professor);}

}
