package com.example.studentservice.controller;

import com.example.studentservice.dto.StudentRequest;
import com.example.studentservice.dto.StudentResponse;
import org.springframework.web.bind.annotation.*;

import com.example.studentservice.service.StudentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

  private final StudentService studentService;

  @PostMapping
  public StudentResponse save(@RequestBody StudentRequest studentRequest) {
    return studentService.save(studentRequest);
  }

  @PutMapping
  public void delete(StudentRequest studentRequest){
     studentService.delete(studentRequest);
  }

}
