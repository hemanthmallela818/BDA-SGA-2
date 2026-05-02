package com.example.studentapp;

import com.example.studentapp.entity.Course;
import com.example.studentapp.entity.Student;
import com.example.studentapp.repository.CourseRepository;
import com.example.studentapp.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testFindAllStudentsWithCourse() {
        Course course = new Course();
        course.setCourseName("Biology");
        courseRepository.save(course);

        Student student = new Student();
        student.setName("John Doe");
        student.setEmail("john@example.com");
        student.setCourse(course);
        studentRepository.save(student);

        List<Student> students = studentRepository.findAllStudentsWithCourse();
        assertThat(students).isNotEmpty();
        
        boolean found = students.stream()
            .anyMatch(s -> "John Doe".equals(s.getName()) && "Biology".equals(s.getCourse().getCourseName()));
        assertThat(found).isTrue();
    }
}
