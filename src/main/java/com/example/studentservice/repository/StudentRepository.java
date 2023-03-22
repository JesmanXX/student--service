package com.example.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentservice.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {}
