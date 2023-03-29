package com.example.studentservice.mapper;

import com.example.studentservice.domain.Student;
import com.example.studentservice.dto.StudentRequest;
import com.example.studentservice.dto.StudentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IStudentMapper {

    Student from(StudentRequest studentRequest);
    StudentResponse to(Student save);
}
