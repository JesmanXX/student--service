package com.example.studentservice.controller;

import com.example.studentservice.domain.Student;
import com.example.studentservice.dto.StudentRequest;
import com.example.studentservice.dto.StudentResponse;
import com.example.studentservice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

  private final StudentService studentService;

  @PostMapping
  public StudentResponse save(@RequestBody StudentRequest studentRequest) {
    return studentService.save(studentRequest);
  }

  @GetMapping("/{id}")
  public StudentResponse findById(@PathVariable Long id) {
    return studentService.findById(id);
  }

  @GetMapping
  public List<StudentResponse> findAll() {
    return studentService.findAll();
  }

  @PutMapping("/{id}")
  public StudentResponse update(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
    return studentService.update(id, studentRequest);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    studentService.deleteById(id);
  }

}
