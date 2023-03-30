package com.example.studentservice.dto;

import com.example.studentservice.domain.Student;
import lombok.Data;

@Data
public class StudentResponse {

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;

    public StudentResponse(Student student) {
        this.firstName = getFirstName();
        this.lastName = getLastName();
        this.username = getUsername();
        this.password = getPassword();
        this.email = getEmail();
        this.age = getAge();
    }
}
