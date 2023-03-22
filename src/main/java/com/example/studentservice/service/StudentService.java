package com.example.studentservice.service;

import org.springframework.stereotype.Service;

import com.example.studentservice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;
}
