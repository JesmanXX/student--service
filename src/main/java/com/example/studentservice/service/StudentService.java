package com.example.studentservice.service;

import com.example.studentservice.domain.Student;
import com.example.studentservice.dto.StudentRequest;
import com.example.studentservice.dto.StudentResponse;
import com.example.studentservice.mapper.IStudentMapper;
import org.springframework.stereotype.Service;

import com.example.studentservice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

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
    Student student = studentRepository.findById(id).orElse(null);
    return new StudentResponse(student);
  }

  public List<Student> findAll() {
    return studentRepository.findAll();
  }

  public StudentResponse update(Long id, StudentRequest studentRequest) {
    Student student = studentRepository.findById(id).orElse(null);

    assert student != null;
    student.setFirstName(studentRequest.getFirstName());
    student.setLastName(studentRequest.getLastName());
    student.setUsername(studentRequest.getUsername());
    student.setPassword(studentRequest.getPassword());
    student.setEmail(studentRequest.getEmail());
    student.setAge(studentRequest.getAge());

    Student updatedStudent = studentRepository.save(student);

    return new StudentResponse(updatedStudent);
  }

  public void deleteById(Long id) {
    studentRepository.deleteById(id);
  }

  public void delete(StudentRequest studentRequest){
    delete(studentRequest);
  }
}
