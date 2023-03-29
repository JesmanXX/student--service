package com.example.studentservice.service;

import com.example.studentservice.domain.Student;
import com.example.studentservice.dto.StudentRequest;
import com.example.studentservice.dto.StudentResponse;
import com.example.studentservice.mapper.IStudentMapper;
import org.springframework.stereotype.Service;

import com.example.studentservice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;
  private final IStudentMapper studentMapper;

  public StudentResponse save(StudentRequest studentRequest){
    Student student = studentMapper.from(studentRequest);
    return studentMapper.to(studentRepository.save(student));
  }

  public void delete(StudentRequest studentRequest){
    delete(studentRequest);
  }
}
