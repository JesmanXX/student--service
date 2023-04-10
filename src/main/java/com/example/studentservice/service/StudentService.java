package com.example.studentservice.service;

import com.example.studentservice.domain.Student;
import com.example.studentservice.dto.StudentRequest;
import com.example.studentservice.dto.StudentResponse;
import com.example.studentservice.mapper.IStudentMapper;
import org.springframework.stereotype.Service;

import com.example.studentservice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;
  private final IStudentMapper studentMapper;

  public StudentResponse save(StudentRequest studentRequest){
    Student student = studentMapper.from(studentRequest);
    return studentMapper.to(studentRepository.save(student));
  }

  public StudentResponse findById(Long id) {
    Student student = studentRepository.findById(id).orElseThrow(null);
    return studentMapper.to(student);
  }

  public List<StudentResponse> findAll() {
    return studentRepository.findAll().stream().map(studentMapper::to).collect(Collectors.toList());
  }

  public StudentResponse update(Long id, StudentRequest studentRequest) {
    Student student = studentRepository.findById(id).orElseThrow(null);

    student.setFirstName(studentRequest.getFirstName());
    student.setLastName(studentRequest.getLastName());
    student.setUsername(studentRequest.getUsername());
    student.setPassword(studentRequest.getPassword());
    student.setEmail(studentRequest.getEmail());
    student.setAge(studentRequest.getAge());

    Student updatedStudent = studentRepository.save(student);

    return studentMapper.to(updatedStudent);
  }

  public void deleteById(Long id) {
    studentRepository.deleteById(id);
  }

}
