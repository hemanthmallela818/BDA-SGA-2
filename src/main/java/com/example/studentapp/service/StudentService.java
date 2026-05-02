package com.example.studentapp.service;

import com.example.studentapp.entity.Student;
import com.example.studentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAllStudentsWithCourse();
    }

    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    public List<Student> getStudentsByCourse(String courseName) {
        return studentRepo.findStudentsByCourseName(courseName);
    }
}
