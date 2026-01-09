package com.scientiaunviversity.backend25.controllers;

import com.scientiaunviversity.backend25.domain.ClassGroup;
import com.scientiaunviversity.backend25.services.ClassGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class_groups")
public class ClassGroupController {

    private final ClassGroupService classGroupService;

    public ClassGroupController(ClassGroupService classGroupService) {
        this.classGroupService = classGroupService;
    }

    @GetMapping
    public List<ClassGroup> getAll() {return classGroupService.getAll();}

    @GetMapping("/{id}")
    public ClassGroup getById(@PathVariable Long id) {return classGroupService.getById(id);}

    @PostMapping
    public ClassGroup create(@RequestBody ClassGroup classGroup) {return  classGroupService.create(classGroup);}
}
