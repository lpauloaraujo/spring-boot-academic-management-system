package com.scientiaunviversity.backend25.controllers;

import com.scientiaunviversity.backend25.DTOs.request.ClassGroupRequestDTO;
import com.scientiaunviversity.backend25.DTOs.response.ClassGroupResponseDTO;
import com.scientiaunviversity.backend25.domain.ClassGroup;
import com.scientiaunviversity.backend25.mappers.ClassGroupMapper;
import com.scientiaunviversity.backend25.services.ClassGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/class_groups")
public class ClassGroupController {

    private final ClassGroupService classGroupService;
    private final ClassGroupMapper classGroupMapper;

    public ClassGroupController(ClassGroupService classGroupService, ClassGroupMapper classGroupMapper) {
        this.classGroupService = classGroupService;
        this.classGroupMapper = classGroupMapper;
    }

    @GetMapping
    public List<ClassGroupResponseDTO> getAll() {
        List<ClassGroup> classGroupList = classGroupService.getAll();
        List<ClassGroupResponseDTO> classGroupResponseDTOList = new ArrayList<>();
        for (ClassGroup classGroup : classGroupList) {
            classGroupResponseDTOList.add(classGroupMapper.toResponse(classGroup));
        } return classGroupResponseDTOList;
    }

    @GetMapping("/{id}")
    public ClassGroupResponseDTO getById(@PathVariable Long id) {
        return classGroupMapper.toResponse(classGroupService.getById(id));
    }

    @PostMapping
    public ClassGroupResponseDTO create(@RequestBody ClassGroupRequestDTO classGroupRequestDTO) {
        return  classGroupMapper.toResponse(classGroupService.create(classGroupRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ClassGroupResponseDTO delete(@PathVariable Long id) {
        return classGroupMapper.toResponse(classGroupService.delete(id));
    }

}
